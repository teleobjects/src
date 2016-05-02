ArrayList<String> places, results;
int placeTypeIndex;

void initPlaces() {
  places = new ArrayList();
  String[] placeTypes = loadStrings("csv/place_types_short.csv");
  for (int i=0; i<placeTypes.length; i++) {
    places.add((placeTypes[i]));
  }
}

void searchPlaces() {
  String types = places.get(pageIndex).toLowerCase();
  int radius = 500;
  results = new ArrayList();
  String placesUrl = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+latitude+","+longitude+"&radius="+radius+"&types="+encode(types)+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c"; // &keyword=vegetarian&
  String placesContent[] = loadUrl(placesUrl);
  if (placesContent != null) {
    String placesFragment ="";

    for (int i=0;i<placesContent.length;i++) {
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
          for (int j=0;j<placeDetailContent.length;j++) {
            placeDetailFragment += placeDetailContent[j];
          }
          processing.data.JSONObject placeDetailJSON = processing.data.JSONObject.parse(placeDetailFragment);
          processing.data.JSONObject placeResult = placeDetailJSON.getJSONObject("result");
          processing.data.JSONObject placeGeometry = placeResult.getJSONObject("geometry");
          //println(placeGeometry);
          results.add(cleanUp(placeResult.getString("name")+" IS OPEN",true));
          println(placeResult.getString("name"));
        }

      }
      placed = true;
    }
  }
}