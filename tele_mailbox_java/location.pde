ArrayList<String> locations;
String provider;
double longitude, latitude, altitude, accuracy;
String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;

boolean hardLocation = true;

void initLocation() {
  if (hardLocation) {
    // home
    latitude = 40.7352735;
    longitude = -73.95551;
    provider = "fixed";
    located = true;
  } else {
    String url = "http://www.geoplugin.net/json.gp?ip="+externalIP;
    println(url);
    String[] geopluginContent = loadStrings(url);
    if (geopluginContent != null) {
      saveStrings("json\\geolocation.json", geopluginContent);
      String jsonFragment = "";
      for (int i=0; i<geopluginContent.length; i++) {
        jsonFragment += geopluginContent[i];
      }
      JSONObject geolocatedData = JSONObject.parse(jsonFragment);
      latitude = geolocatedData.getFloat("geoplugin_latitude");
      longitude = geolocatedData.getFloat("geoplugin_longitude");
      provider = "geoplugin";
      located = true;
    }
  }
  updateLocation();
}

void updateLocation() {
  if (located && !found) {
    if (longitude != 0) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      println(url);
      String[] geolocationContent = loadStrings(url);
      if (geolocationContent != null) {
        //saveStrings("json/location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        JSONObject geolocatedData = JSONObject.parse(jsonFragment);
        JSONObject address = geolocatedData.getJSONObject("address");
        country = address.getString("country");
        countryCode = address.getString("country_code");
        state = address.getString("state");
        county = address.getString("county");
        city = address.getString("city");
        //suburb = address.getString("suburb");
        neighbourhood =  address.getString("neighbourhood");
        street = address.getString("road");
        houseNumber = address.getString("house_number");
        //building = address.getString("building");
        postCode = address.getString("postcode");
        found = true;
      }
    }
  }
  //////////////
  locations = new ArrayList();
  if (!found) {
    locations.add("WE'RE LOST...");
    //found = = false;
  } else {
    locations.add(cleanUp(getCoordinate(latitude, true)+" "+getCoordinate(longitude, false), true));
    locations.add(cleanUp(houseNumber+" "+street, true));
    locations.add(cleanUp(neighbourhood+" "+postCode, true));
    locations.add(cleanUp(city+", "+state, true));
  }
}