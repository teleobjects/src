/////////////////////////////////////
// MAIL
/////////////////////////////////////

class Mail {
  ArrayList<String> mails;
  int mailIndex;
  boolean updated;
  long lastUpdated;

  Mail() {
  }

  void update() {
    mails = new ArrayList<String>();
    String[] mailBuffer = loadUrl("http://teleobjects.com/api/proxy.php?mail=true");
    for (int i=0; i<mailBuffer.length; i++) {
      int currentMail = mailBuffer.length - i - 1;
      if (mailBuffer[currentMail].indexOf("=?") == - 1) {
        String[] items = splitTokens (mailBuffer[currentMail], "\t");
        if (items.length>0) {
          String name =  items[0];
          if (name.indexOf("<") != -1) {
            name = name.substring(0, name.indexOf("<"));
          }
          name = removeQuotes(name);

          if (items.length>1) {
            String date = items[1].substring(0, 11);
            mails.add(createString(cleanUp(date, false), CENTERED, 0, 0, 15));
            // mails.add(createString(" ", INSTANT, 1, 1, 1));
          }
          mails.add(createString(" ", BLANK, 0, 0, 1));
          mails.add(createString(cleanUp(name, true), SCROLL_PUSH_RIGHT, 0, 1, 5));
          // mails.add(createString(" ", BLANK, 0, 0, 1));
          if (items.length > 2) {
            String subject =  cleanUp(items[2]);
            mails.add(createString(subject, SCROLL_ALL_RIGHT, 1, 1, 20));
          }
        }
      }
    }
    if (mails.size() == 0) {
      mails.add("No unread emails");
    }
    updated = true;
    lastUpdated = time.currentTimeStamp;
  }

  ArrayList<String> getPages() {
    if (!updated) update();

    return mails;
  }
}

/////////////////////////////////////
// PLACES
/////////////////////////////////////

class Places {
  ArrayList<String> places, results;
  int placeTypeIndex;
  
  boolean placed;

  Places () {
    init();
  }

  void init() {
    places = new ArrayList<String>();
    String[] placeTypes = loadStrings("csv/place_types_short.csv");
    for (int i=0; i<placeTypes.length; i++) {
      places.add((placeTypes[i]));
    }
  }

  ArrayList<String> getPages() {
    return places;
  }

  void search() {
    String types = places.get(pageIndex).toLowerCase();
    int radius = 500;
    results = new ArrayList<String>();
    String placesUrl = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+geolocation.latitude+","+geolocation.longitude+"&radius="+radius+"&types="+encode(types)+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c"; // &keyword=vegetarian&
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
        results.add(cleanUp("FOUND "+numberOfPlaces+" "+types+"S", true));

        for (int i=0; i<numberOfPlaces && i < numberOfPlaces && i < 10; i++) {
          processing.data.JSONObject onePlace = placesArray.getJSONObject(i);
          String onePlaceId = onePlace.getString("place_id");
          String placeDetailsUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+onePlaceId+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c";
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
            results.add(cleanUp(placeResult.getString("name")+" IS OPEN", true));
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
  String newsKey = "df5b7c70d8675c367c0cbacc5b8879e0:11:74861169";
  ArrayList<Article> articles;
  // int articleIndex;

  News() {
  }

  void update() {
    articles = new ArrayList<Article>();
    // articleIndex = 0;

    String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
    String[] newsResponse = loadUrl(newsUrl);
    if (newsResponse.length>0) {
      String newsFragment = newsResponse[0];
      JSONObject newsJSON = processing.data.JSONObject.parse(newsFragment);
      JSONArray newsArray = newsJSON.getJSONArray("results");
      int numberOfNews = newsArray.size();
      for (int i=1; i<numberOfNews; i++) {
        JSONObject newsContent = newsArray.getJSONObject(i);
        String newsTitle = newsContent.getString("title");
        String newsSection = newsContent.getString("section");
        String newsKeywords = newsContent.getString("adx_keywords");
        String newsAbstract = newsContent.getString("abstract");
        String newsType = newsContent.getString("section");
        String imageUrl = "";
        try {
          JSONArray mediaArray = newsContent.getJSONArray("media");
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
        articles.add(article);   
      }
    }
  }

  ArrayList<String> getPages() {
    update();
    ArrayList<String> pages = new ArrayList<String>();
    if (articles.size() == 0) {
      pages.add("CAN'T CONNECT TO NY TIMES");
      return pages;
    }    

    pages.add(createString("", BLANK, 0, 0, 0));

    pages.add(createString("LATEST FROM NY TIMES", SCROLL_PUSH_RIGHT, 0, 10, 20));
    // pages.add(createString(" ", SCROLL_PUSH_RIGHT, 0, 1, 10));
    for (Article article : articles) {

      if (article.keywords.size() > 0) {
        pages.add(createString(article.imageUrl, IMAGE, 0, 0, 0));
        for (String keyword : article.keywords) {
          pages.add(createString(keyword, CENTERED, 0, 0, 10));
        }
        // pages.add(createString("", BLANK, 1, 1, 1));
        pages.add(createString(cleanUp(article.title, false), SCROLL_PUSH_RIGHT, 1, 10, 0));
        pages.add(createString(cleanUp(article.content, false), SCROLL_PUSH_RIGHT, 1, 10, 0));
        // pages.add(createString("", BLANK, 1, 1, 1));
      }
    }
    return pages;
  }
}

class Article {
  String title;
  String content;
  ArrayList<String> keywords;
  String imageUrl;

  Article() {
    keywords = new ArrayList();
  }

  void display() {
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
    return cleanUp(removeSpaces(str), true);
  }



/////////////////////////////////////
// GEOLOCATION
/////////////////////////////////////

class Geolocation {
  String provider;
  double longitude, latitude, altitude, accuracy;
  String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;
  long lastUpdated;
  boolean updated;
  boolean located;

  boolean hardLocation = true;

  Geolocation() {
    if (!android) {
      init();
    }
  }

  void init() {
    if (hardLocation) {
      latitude = 40.7352735;
      longitude = -73.95551;
      provider = "fixed";
      located = true;
    } else {
      String url = "http://www.geoplugin.net/json.gp?ip="+externalIP;
      String[] geopluginContent = loadUrl(url);
      if (geopluginContent != null) {
        saveStrings("json\\geolocation.json", geopluginContent);
        String jsonFragment = "";
        for (int i=0; i<geopluginContent.length; i++) {
          jsonFragment += geopluginContent[i];
        }
        processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
        latitude = geolocatedData.getFloat("geoplugin_latitude");
        longitude = geolocatedData.getFloat("geoplugin_longitude");
        provider = "geoplugin";
        located = true;
      }
    }
  }

  void update() {
    if (located && !updated && online) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      String[] geolocationContent = loadUrl(url);
      if (geolocationContent != null) {
        saveLocal("location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        if (!jsonFragment.contains("error")) {
          processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
          processing.data.JSONObject address = geolocatedData.getJSONObject("address");
          country = address.getString("country");
          countryCode = address.getString("country_code");
          state = address.getString("state");
          county = address.getString("county");
          city = address.getString("city");
          if (!address.isNull("suburb")) suburb = address.getString("suburb");
          if (!address.isNull("house_number")) neighbourhood =  address.getString("neighbourhood");
          if (!address.isNull("road")) street = address.getString("road");
          if (!address.isNull("house_number")) houseNumber = address.getString("house_number");
          if (!address.isNull("building")) building = address.getString("building");
          if (!address.isNull("postcode")) postCode = address.getString("postcode");
          updated = true;
          lastUpdated = time.currentTimeStamp;
        }
      }
    }
  }

  ArrayList<String> getPages() {
    ArrayList<String> pages = new ArrayList<String>();
    if (!updated) {
      pages.add("We're lost...");
    } else {
      pages.add(cleanUp(getCoordinate(latitude, true)+" "+getCoordinate(longitude, false), false));
      pages.add(cleanUp(houseNumber+" "+street, false));
      pages.add(cleanUp(neighbourhood+" "+postCode, false));
      pages.add(cleanUp(city+", "+state, false));
    }
    return pages;
  }
}

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
  String[] monthNames ={"January", "February", "March", "April", "May", "June", "July", 
  "August", "September", "October", "November", "December"};

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
    month = cal.get(Calendar.MONTH);
    monthStr = monthNames[month];
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
  boolean updated;
  long lastUpdated;
  int weatherRefresh = 300; 

  float windSpeed, windDeg, windGust, rain, clouds;
  String condition, conditionMain;
  float  temp, pressure, humidity;

  Weather() {
  }

  void update() {
    if (!updated && geolocation.updated) {
      String[] weatherContent = null;

      // weatherContent = loadLocal("weather.json");

      if (weatherContent == null && online) {
        String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="+geolocation.latitude+"&lon="+geolocation.longitude+"&appid=1ebe1cb0874724fa15a5a109140d6e4e"+"&units=imperial";
        weatherContent = loadUrl(weatherUrl);
        saveLocal("weather.json", weatherContent);
      }

      if (weatherContent != null) {
        String weatherFragment = weatherContent[0];
        processing.data.JSONObject weatherJSON = processing.data.JSONObject.parse(weatherFragment);
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
        lastUpdated = time.currentTimeStamp;
      }
    }
  }

  ArrayList<String> getPages() {
    if (!updated) update();
    pages = new ArrayList<String>();
    if (!updated) {
      pages.add(cleanUp("No weather info..."));
    } else {
      pages.add(createString("", FONT, 1, 1, 0));

      pages.add(createString(cleanUp(condition+" in "+geolocation.neighbourhood, false), SCROLL_ALL_RIGHT, 0, 0, 20));
      pages.add(createString("", BLANK, 0, 0, 0));
      pages.add(createString(cleanUp("IT'S "+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? char(DEGREE)+"c" : char(29)+"f"), false), CENTERED, 0, 0, 10));
      pages.add(createString(cleanUp(int(humidity)+"% humid", false), CENTERED, 0, 0, 8));
      pages.add(createString(cleanUp("pressure "+int(pressure)+"mPa", false), CENTERED, 0, 0, 8));
      pages.add(createString(cleanUp(int(clouds)+"% cloudy", false), CENTERED, 0, 0, 8));
      pages.add(createString(cleanUp("wind "+int(windSpeed) +"m/h "+(int)windDeg+char(DEGREE)+" "+getHeading(windDeg), false), CENTERED, 0, 0, 10));
      // pages.add(createString("", SCROLL_PUSH_RIGHT, 0, 1, 20));
    }
    return pages;
  }
}