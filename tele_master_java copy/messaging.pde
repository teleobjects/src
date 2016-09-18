
class Messaging {

  ArrayList<Dweet> dweets;
  
  boolean dweet;
  Dweet latestDweet;
  float dweetA, dweetTargetA = 0;
  String lastCreated = "";
  boolean dweeted;
  long lastDweet;
  String teleobject = "ticker";
  String thing = "teleobject";

  Messaging() {
    latestDweet = new Dweet();
    // dweets = new ArrayList<Dweet>();
  }

  void getDweet() {
    network.pingStart = millis();
    String thing= "teleobjects";
    String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
    println("getting dweet");
    String[] buffer = loadStrings(url);
    if (buffer != null) {
      latestDweet.parse(buffer[0], true);
      if (!lastCreated.equals(latestDweet.created_)) {
        println(buffer);
        lastCreated = latestDweet.created_;
        network.pingTime = int(millis()-network.pingStart);

        boolean flag = true;

        for (int i=0; i<latestDweet.properties.size(); i++) {
          String property = latestDweet.properties.get(i);
          if (property.equals("teleobject")) {
            String teleobject_ = latestDweet.values.get(i);
            if (teleobject_.equals(teleobject)) {
              println("sent by my self"); 
              flag = false;
            }
          }
            // if (property.equals("NEWS")&& true) {
            //   if (debug) println("news");
            //   String content = latestDweet.values.get(i);
            //   String[] items = splitTokens(content, "|");
            //   String img = items[1];
            //   display.imagery = requestImage(img);
            //   display.mode = IMAGERY;
            //   lastTilt = 0;
            // }
          }
          if (flag) {
            println("good dweet");
            dweeted = true;
            dweetA = 255;
          }
        }
      }
    }

    void sendDweetQuietly(String key_, String value_) {
      network.pingStart = millis();
      String url = "https://dweet.io:443/dweet/quietly/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
      String[] buffer = loadUrl(url);
      println(url);
      if (buffer != null) {
        // latestDweet.parse(buffer[0], false);
        latestDweet.info = value_;
        network.pingTime = int(millis()-network.pingStart);
        dweetA = 255;
      }
    }

    void sendDweet(String key_, String value_) {
      network.pingStart = millis();
      String url = "https://dweet.io:443/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
      String[] buffer = loadStrings(url);
      //println(url);
      if (buffer != null) {
          latestDweet.parse(buffer[0], false);
        network.pingTime = int(millis()-network.pingStart);
        dweetA = 255;
      }
    }

    void displayDweet(float thisX, float thisY) {
      dweetA += (dweetTargetA - dweetA)*.01;
      if (latestDweet.info != null) {
        pushMatrix();
        translate(thisX, thisY);
        textAlign(LEFT);
        textFont(font, 16);
        fill(redColor, dweetA);
        text(latestDweet.info, 0, 0);
        popMatrix();
      }
    }
  }

  class Dweet {
    String created_ = "";
    String content_;
    String info;
    String thing_;

    ArrayList<String> properties;
    ArrayList<String> values;
    Dweet() {
    }

    void parse(String d, boolean getting) {
      processing.data.JSONObject dweetData = processing.data.JSONObject.parse(d);
      String this_ = dweetData.getString("this");
      properties = new ArrayList();
      values = new ArrayList();
      if (this_.equals("succeeded")) {
        String by_ = dweetData.getString("by");
        String the_ = dweetData.getString("the");
        processing.data.JSONObject withObject = null;
        if (getting) {
          processing.data.JSONArray withArray = dweetData.getJSONArray("with");
          withObject= withArray.getJSONObject(0);
        } else {
          withObject = dweetData.getJSONObject("with");
        }
        thing_  = removeBrackets(withObject.getString("thing"));
        created_ = withObject.getString("created");
        processing.data.JSONObject withContent =  withObject.getJSONObject("content");
        String[] properties_ = (String[]) withContent.keys().toArray(new String[withContent.size()]);
        content_ = "";
        for (int i=0; i<properties_.length; i++) {
          properties.add(removeBrackets(properties_[i]));
          values.add(removeBrackets(withContent.getString(properties_[i])));
          content_ += removeBrackets(properties_[i])+"|"+ removeBrackets(withContent.getString(properties_[i]));
        }
      //info = "this "+this_+" by "+by_+" the "+the_+" thing "+thing_;//+" content "+content_;
    } else {
      int with_ = dweetData.getInt("with");
      String because_ = dweetData.getString("because");
      //info = "this "+this_+" with "+with_+" because "+because_;
    }
  }
}