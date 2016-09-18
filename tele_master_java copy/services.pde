/////////////////////////////////////
// PLACES
/////////////////////////////////////

class Places {
  ArrayList<String> placeList, results;
  String types;
  boolean placed;
  String appKey;

  Places () {
    init();
  }

  void init() {
    if (credentials.credentials != null) {
      appKey = credentials.credentials[2];
    }
    placeList = new ArrayList<String>();
    String[] placeTypes = loadStrings("csv/place_types_short.csv");
    for (int i=0; i<placeTypes.length; i++) {
      placeList.add((placeTypes[i]));
    }
  }

  void search(String str) {
    types = placeList.get(ticker.pageIndex);
    int radius = 500;
    results = new ArrayList<String>();
    String placesUrl = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+geolocation.latitude+","+geolocation.longitude+"&radius="+radius+"&types="+encode(types)+"&key="+appKey; // &keyword=vegetarian&
    String placesContent[] = loadUrl(placesUrl);
    if (placesContent != null) {
      String placesFragment ="";
      for (int i=0; i<placesContent.length; i++) {
        placesFragment += placesContent[i];
      }
      processing.data.JSONObject placesJSON = processing.data.JSONObject.parse(placesFragment);
      if (placesJSON != null) {
        processing.data.JSONArray placesArray = placesJSON.getJSONArray("results");
        int numberOfPlaces = placesArray.size();

        for (int i=0; i<numberOfPlaces && i < numberOfPlaces && i < 10; i++) {
          processing.data.JSONObject onePlace = placesArray.getJSONObject(i);
          String onePlaceId = onePlace.getString("place_id");
          String placeDetailsUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+onePlaceId+"&key="+appKey;
          String[] placeDetailContent = loadUrl(placeDetailsUrl);
          if (placeDetailContent != null) {
            String placeDetailFragment ="";
            for (int j=0; j<placeDetailContent.length; j++) {
              placeDetailFragment += placeDetailContent[j];
            }
            processing.data.JSONObject placeDetailJSON = processing.data.JSONObject.parse(placeDetailFragment);
            processing.data.JSONObject placeResult = placeDetailJSON.getJSONObject("result");
            //processing.data.JSONObject placeGeometry = placeResult.getJSONObject("geometry");
            //println(placeGeometry);
            results.add(placeResult.getString("name"));
            println(placeResult.getString("name"));
          }
        }
        placed = true;
      }
    }
  }
}

/////////////////////////////////////
// NEWS
/////////////////////////////////////

class News {
  String newsKey;// = "df5b7c70d8675c367c0cbacc5b8879e0:11:74861169";
  ArrayList<Article> articles;
  boolean updated;
  long lastUpdated;

  News() {
    if (credentials.credentials != null) {
      newsKey = credentials.credentials[4];
    }
  }

  void update() {
    String[] newsContent = null;

    //newsContent = loadStrings("tmp/news.json");
    //lastUpdated = getFileTimeStamp("tmp", "news.json");

    if (network.online && refresh) { // add time stamp check
      String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
      newsContent = loadUrl(newsUrl);
      lastUpdated = time.currentTimeStamp;
      //saveLocal("news.json", newsContent);
    } 

    if (newsContent != null) {
      articles = new ArrayList<Article>();
      String newsFragment = newsContent[0];
      JSONObject newsJSON = processing.data.JSONObject.parse(newsFragment);
      JSONArray newsArray = newsJSON.getJSONArray("results");
      int numberOfNews = newsArray.size();
      for (int i=1; i<numberOfNews; i++) {
        JSONObject newsObject = newsArray.getJSONObject(i);
        String newsTitle = newsObject.getString("title");
        String newsSection = newsObject.getString("section");
        String newsKeywords = newsObject.getString("adx_keywords");
        String newsAbstract = newsObject.getString("abstract");
        String newsAuthor;
        if (!newsObject.isNull(newsObject.getString("byline")))  newsAuthor = newsObject.getString("byline");
        // String newsType = newsObject.getString("section");
        String imageUrl = "";
        try {
          JSONArray mediaArray = newsObject.getJSONArray("media");
          JSONObject mediaContent = mediaArray.getJSONObject(0);
          JSONArray mediaMetadataArray = mediaContent.getJSONArray("media-metadata");
          JSONObject imageData = mediaMetadataArray.getJSONObject(0);
          imageUrl = imageData.getString("url");
          // println(imageUrl);
        } 
        catch(Exception e) {
          //println("no media");
        }
        String items[] = splitTokens(newsKeywords, ";");
        int count = 0;
        Article article = new Article();
        article.imageUrl = imageUrl;
        article.title = newsTitle;
        article.section = newsSection ;
        article.content = newsAbstract;
        for (int j=0; j<items.length && count < 5; j++) {
          if (items[j].length() < 28) {
            String keyword = cleanKeyword(items[j]);
            if (keyword != null && keyword.length() >0 ) {
              count ++;
              article.keywords.add(keyword);
            }
          }
        }    
        if (article.keywords.size() > 0) articles.add(article);
      }
      updated = true;
    }
  }

  String cleanKeyword(String str) {
    int parenthesis = str.indexOf("(");
      if (parenthesis != -1) {
        str = removeSpaces(str.substring(0, parenthesis-1));
      }
      int comma = str.indexOf(",");
      if (comma != -1) {
        str = str.substring(comma+1, str.length())+" "+removeSpaces(str.substring(0, comma));
      }
      return removeSpaces(str);
    }
  }

  class Article {
    String title;
    String content;
    String author;
    String section;
    String source;
    String date;
    ArrayList<String> keywords = new ArrayList<String>();
    String imageUrl;
  }

/////////////////////////////////////
// GEOLOCATION
/////////////////////////////////////



class Geolocation {
  String provider;
  double longitude, latitude, altitude, accuracy;
  String displayName;
  String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;
  long lastUpdated;
  boolean updated;
  boolean located;

  String formattedAddress;

  Geolocation() {
  }

  void update() {
    String[] geolocationContent = null;//loadLocal("location.json");
    //lastUpdated = getFileTimeStamp("tmp", "location.json");
    String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitude+","+longitude+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c";
    if (located && network.online && refresh) {
      geolocationContent = loadUrl(url);      
    }
    if (geolocationContent != null) { 
      lastUpdated = time.currentTimeStamp;   
      String jsonFragment ="";
      for (int i=0; i<geolocationContent.length; i++) {
        jsonFragment += geolocationContent[i];
      }
      processing.data.JSONObject geolocationJSON = processing.data.JSONObject.parse(jsonFragment);
      processing.data.JSONArray results = geolocationJSON.getJSONArray("results");
      formattedAddress = results.getJSONObject(0).getString("formatted_address");
      println(geolocationContent);
      updated = true;
    }
  }
}

// class Geolocation {
//   String provider;
//   double longitude, latitude, altitude, accuracy;
//   String displayName;
//   String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;
//   long lastUpdated;
//   boolean updated;
//   boolean located;

//   Geolocation() {
//   }

//   void update() {
//     String[] geolocationContent = null;//loadLocal("location.json");
//     //lastUpdated = getFileTimeStamp("tmp", "location.json");

//     //http://api.openweathermap.org/data/2.5/weather?lat=28.46926673326195&lon=-16.24783340413054&appid=1ebe1cb0874724fa15a5a109140d6e4e&units=imperial

//     if (located && network.online && refresh) {
//       //String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";

//       String url = "http://nominatim.openstreetmap.org/reverse?lat=28.46926673326195&lon=-16.24783340413054&format=json";

//         //String url = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&format=json";

//         geolocationContent = loadUrl(url);
//       lastUpdated = time.currentTimeStamp;
//       //saveLocal("location.json", geolocationContent);
//     }
//     if (geolocationContent != null) {    
//       String jsonFragment = geolocationContent[0];
//       processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
//       processing.data.JSONObject address = geolocatedData.getJSONObject("address");
//       if (!address.isNull("display_name")) displayName = address.getString("display_name");
//       if (!address.isNull("country")) country = address.getString("country");
//       if (!address.isNull("country_code")) countryCode = address.getString("country_code");
//       if (!address.isNull("state")) state = address.getString("state");
//       if (!address.isNull("county")) county = address.getString("county");
//       if (!address.isNull("city")) city = address.getString("city");
//       if (city == null && !address.isNull("town")) city = address.getString("town");
//       if (!address.isNull("suburb")) suburb = address.getString("suburb");
//       if (!address.isNull("neighbourhood")) neighbourhood = address.getString("neighbourhood");
//       if (!address.isNull("road")) street = address.getString("road");
//       if (street == null && !address.isNull("pedestrian")) street = address.getString("pedestrian");
//       if (!address.isNull("house_number")) houseNumber = address.getString("house_number");
//       if (!address.isNull("building")) building = address.getString("building");
//       if (!address.isNull("postcode")) postCode = address.getString("postcode");
//       updated = true;
//     }
//   }
// }

/////////////////////////////////////
// TIME
/////////////////////////////////////

class Time {
  String dayStr, monthStr;
  int day;
  int month;
  int year;
  long currentTimeStamp = 0;
  long startTimeStamp = 0;

  String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
  String[] monthNames ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

  Time() {
    init();
    update();
  }

  void init() {
    Date d = new Date();
    startTimeStamp = d.getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    int dayTemp = cal.get(Calendar.DAY_OF_WEEK);
    dayTemp -= 2;  // ???
    if (dayTemp < 0) dayTemp += 7;
    dayStr = dayNames[dayTemp];
    day = cal.get(Calendar.DAY_OF_MONTH);
    month = cal.get(Calendar.MONTH)+1;
    monthStr = monthNames[month-1];
    year = cal.get(Calendar.YEAR);
    currentTimeStamp = d.getTime();
  }

  void update() {
    Date d = new Date();
    currentTimeStamp = d.getTime();
  }
}

/////////////////////////////////////
// WEATHER
/////////////////////////////////////

class Weather {
  String appId;

  boolean updated;
  long lastUpdated;
  int weatherRefresh = 300;
  float windSpeed, windDeg, windGust, rain, clouds;
  String condition, conditionMain;
  float  temp, pressure, humidity;
  String station;

  Weather() {
    if (credentials.credentials != null) {
      appId = credentials.credentials[5];
    }
  }

  void update() {
    String[] weatherContent =  null;//loadLocal("weather.json");
    //lastUpdated = getFileTimeStamp("tmp", "weather.json");

    if (network.online && (refresh || weatherContent != null) && geolocation.located) { 
      String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="+geolocation.latitude+"&lon="+geolocation.longitude+"&appid="+appId+"&units=imperial";
      weatherContent = loadUrl(weatherUrl);
      if (weatherContent != null) {
        //saveLocal("weather.json", weatherContent);
        lastUpdated = time.currentTimeStamp;
      }
    }

    if (weatherContent != null) {
      String weatherFragment = weatherContent[0];
      println(weatherFragment);
      processing.data.JSONObject weatherJSON = processing.data.JSONObject.parse(weatherFragment);
      if (!weatherJSON.isNull("name")) station = weatherJSON.getString("name");
      processing.data.JSONArray weatherArray = weatherJSON.getJSONArray("weather");
      processing.data.JSONObject weather= weatherArray.getJSONObject(0);
      condition = weather.getString("description");
      conditionMain = weather.getString("main");
      processing.data.JSONObject main = weatherJSON.getJSONObject("main");
      temp = main.getFloat("temp");
      humidity = main.getFloat("humidity");
      pressure = main.getFloat("pressure");
      processing.data.JSONObject cloudsData = weatherJSON.getJSONObject("clouds");
      clouds = cloudsData.getFloat("all");
      if (weatherJSON.hasKey("wind")) {
        processing.data.JSONObject windData = weatherJSON.getJSONObject("wind");
        windSpeed =  windData.getFloat("speed");
        if (windData.hasKey("deg")) {
          windDeg = windData.getFloat("deg");
        }
        if (windData.hasKey("gust")) {
          windGust = windData.getFloat("gust");
        }
      }
      if (weatherJSON.hasKey("rain")) {
        processing.data.JSONObject rainData = weatherJSON.getJSONObject("rain");
      }
      if (weatherJSON.hasKey("clouds")) {
        processing.data.JSONObject cloudData = weatherJSON.getJSONObject("clouds");
        clouds = cloudData.getFloat("all");
      }
      updated = true;
    }
  }
}

/////////////////////////////////////
// CREDENTIALS
/////////////////////////////////////

class Credentials {
  String[] credentials;

  Credentials() {
    credentials = loadStrings("key/credentials.csv");
    if (credentials != null) {
      String items[] = splitTokens(credentials[0], ",");
      session = new TembooSession(items[0], items[1], items[2]);
    }
  }
}