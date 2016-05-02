ArrayList<String> weathers;
long weatherUpdated;
int weatherRefresh = 300; // in seconds

float windSpeed, windDeg, windGust, rain, clouds;
String condition, conditionMain;
float  temp, pressure, humidity;

void updateWeather() {
  if ((currentTimeStamp - weatherUpdated)/1000 > weatherRefresh || !forecasted) {
    String[] weatherContent = null;
    forecasted = false;
    //String fileName = "weather.json";
    //File file = new File(fileName);
    //if (file!= null) {
    //  weatherUpdated = file.lastModified();
    //  //if ((currentTimeStamp - weatherUpdated)/1000 < weatherRefresh || !online) {
    //  weatherContent = loadStrings(fileName);
    //  //weatherUpdated = currentTimeStamp;
    //  println("loading local file "+fileName);
    //  //}
    //}
    if (weatherContent == null) {
      String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=1ebe1cb0874724fa15a5a109140d6e4e"+"&units=imperial";
      weatherContent = loadUrl(weatherUrl);
      if (weatherContent != null) {
        //saveStrings("weather.json", weatherContent);
        weatherUpdated = currentTimeStamp;
      }
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
        //rain = rainData.getFloat("3h");
      }
      if (weatherJSON.hasKey("clouds")) {
        processing.data.JSONObject cloudData = weatherJSON.getJSONObject("clouds");
        clouds = cloudData.getFloat("all");
      }
      forecasted = true;
    }
  }
  weathers = new ArrayList();

  if (!forecasted) {
    weathers.add(cleanUp("No weather info..."));
  } else {
    weathers.add(createString(cleanUp(condition+" in "+neighbourhood, true), TICKER, 10, 1, 20));
    weathers.add(createString("", RAIN, 20, 1, 50));
    weathers.add(createString("", BLANK, 10, 1, 1));
    weathers.add(createString(cleanUp("IT'S "+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? char(DEGREE)+"c" : char(29)+"f"), false), CENTERED, 1, 1, 10));
    weathers.add(createString(cleanUp(int(humidity)+"% HUMID", true), CENTERED, 1, 1, 10));
    weathers.add(createString(cleanUp("PRESSURE "+int(pressure)+"mPa", false), CENTERED, 1, 1, 10));
    weathers.add(createString(cleanUp(int(clouds)+"% CLOUDY", true), CENTERED, 10, 1, 10));
    weathers.add(createString(cleanUp("WIND "+int(windSpeed) +"m/h "+(int)windDeg+char(DEGREE)+" "+getHeading(windDeg), false), CENTERED, 1, 1, 10));
    weathers.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));
  }
}

String getHeading(float deg) {
  String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", 
    "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
  int i = int((deg + 11.25)/22.5);
  return directions[i % 16];
}