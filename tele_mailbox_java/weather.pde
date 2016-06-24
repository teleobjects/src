ArrayList<String> weathers;
long weatherUpdated;
int weatherRefresh = 300; // in seconds

float windSpeed, windDeg, windGust, rain, clouds;
String condition, conditionMain;
float  temp, pressure, humidity;

void updateWeather() {
  if ((currentTimeStamp - weatherUpdated)/1000 > weatherRefresh || !forecasted) {
    weathers = new ArrayList();
    String[] weatherContent = null;
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
      println(weatherUrl);
      weatherContent = loadStrings(weatherUrl);
      if (weatherContent != null) {
        //saveStrings("weather.json", weatherContent);
        weatherUpdated = currentTimeStamp;
      }
    }
    if (weatherContent != null) {
      String weatherFragment = weatherContent[0];
      JSONObject weatherJSON = JSONObject.parse(weatherFragment);
      JSONArray weatherArray = weatherJSON.getJSONArray("weather");
      JSONObject weather= weatherArray.getJSONObject(0);
      condition = weather.getString("description");
      conditionMain = weather.getString("main");
      JSONObject main = weatherJSON.getJSONObject("main");
      temp = main.getFloat("temp");
      humidity = main.getFloat("humidity");
      pressure = main.getFloat("pressure");
      JSONObject cloudsData = weatherJSON.getJSONObject("clouds");
      clouds = cloudsData.getFloat("all");
      if (weatherJSON.hasKey("wind")) {
        JSONObject windData = weatherJSON.getJSONObject("wind");
        windSpeed =  windData.getFloat("speed");
        if (windData.hasKey("deg")) {
          windDeg = windData.getFloat("deg");
        }
        if (windData.hasKey("gust")) {
          windGust = windData.getFloat("gust");
        }
      }
      if (weatherJSON.hasKey("rain")) {
        JSONObject rainData = weatherJSON.getJSONObject("rain");
        //rain = rainData.getFloat("3h");
      }
      if (weatherJSON.hasKey("clouds")) {
        JSONObject cloudData = weatherJSON.getJSONObject("clouds");
        clouds = cloudData.getFloat("all");
      }
      forecasted = true;
    }
    if (!forecasted) {
      weathers.add(cleanUp("No weather info..."));
    } else {
      weathers.add(cleanUp(condition+" in "+neighbourhood, true));
      weathers.add(cleanUp("It's "+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? char(DEGREE)+"C" : char(29)+"F"), true));
      weathers.add(cleanUp(int(humidity)+"% humid", true));
      weathers.add(cleanUp("Pressure "+int(pressure), true)+"hPa");
      weathers.add(cleanUp(int(clouds)+"% cloudy", true));
      weathers.add(cleanUp("Wind "+int(windSpeed), true)+"m/h "+cleanUp((int)windDeg+"° "+getHeading(windDeg)));
    }
  }
}

String getHeading(float deg) {
  String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", 
    "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
  int i = int((deg + 11.25)/22.5);
  return directions[i % 16];
}