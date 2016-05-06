ArrayList<String> locations;
String provider;
double longitude, latitude, altitude, accuracy;
String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;

boolean hardLocation = true;

void initLocation() {
  if (!android) {
    if (hardLocation) {
      // home
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
}

void updateLocation() {
  if (located && !found) {
    if (longitude != 0) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      String[] geolocationContent = loadUrl(url);
      if (geolocationContent != null) {
        //saveStrings("json/location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
        processing.data.JSONObject address = geolocatedData.getJSONObject("address");
        country = address.getString("country");
        countryCode = address.getString("country_code");
        state = address.getString("state");
        county = address.getString("county");
        city = address.getString("city");
        //suburb = address.getString("suburb");
        neighbourhood =  address.getString("neighbourhood");
        street = address.getString("road");

        if (!address.isNull("house_number")) {
          houseNumber = address.getString("house_number");
        }
        //building = address.getString("building");
        postCode = address.getString("postcode");
        found = true;
      }
    }
  }
  locations = new ArrayList();
  if (!found) {
    locations.add("We're lost...");
  } else {
    locations.add(cleanUp(getCoordinate(latitude, true)+" "+getCoordinate(longitude, false), true));
    locations.add(cleanUp(houseNumber+" "+street, true));
    locations.add(cleanUp(neighbourhood+" "+postCode, true));
    locations.add(cleanUp(city+", "+state, true));
  }
}