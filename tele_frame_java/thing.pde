ArrayList dweets;
Dweet latestDweet;
float dweetA, dweetTargetA = 0;
String lastCreated = "";
boolean dweeted;
long lastDweet;
int refresh = 2000;
String teleobject = "frame";
String thing = "teleobjects";

void initThing() {
  latestDweet = new Dweet();
  dweets = new ArrayList();
}

void getDweet() {
  if (debug) println("get dweet");
  long pingStart = millis();
  String thing= "teleobjects";
  String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
  String[] buffer = loadStrings(url);
  if (buffer != null) {
    latestDweet.parse(buffer[0], true);
    if (debug) println("got dweet");
    if (!lastCreated.equals(latestDweet.created_)) {
      if (debug) println("new dweet");
      lastCreated = latestDweet.created_;
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
        if (property.equals("CONTACTS") && true) {
          if (debug) println("new contact");
          String content = latestDweet.values.get(i);
          String[] items = splitTokens(content, "|");
          if (items.length> 0) {
            String img = items[1];
            println("got contact");
            lastTilt = 0;

            //String name = 


            if (img != null && !img.equals("null")) {
              display.imagery = loadImage("img/"+img+".png");
              display.mode = IMAGERY;
            }
          }
        }
        if (property.equals("NEWS")) {
          if (debug) println("news");
          String content = latestDweet.values.get(i);
          String[] items = splitTokens(content, "|");
          String img = items[1];
          display.imagery = requestImage(img);
          display.mode = IMAGERY;
          lastTilt = 0;
        }
      }
    }
  }
}

void sendDweet(String key_, String value_) {
  long pingStart = millis();
  String url = "https://thingspace.io/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
  String[] buffer = loadStrings(url);
  println(url);
  if (buffer != null) {
    latestDweet.parse(buffer[0], false);
    //pingTime = int(millis()-pingStart);
    dweetA = 255;
  }
  println("dweeting");
}

void displayDweet(float thisX, float thisY) {
  dweetA += (dweetTargetA - dweetA)*.05;
  if (latestDweet.info != null) {
    pushMatrix();
    translate(thisX, thisY);
    textAlign(LEFT);
    //textFont(fontBold, 20);
    fill(redColor);
    text(latestDweet.info, 0, 0);
    popMatrix();
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

String encode(String name) {
  String encoded = null;
  try { 
    encoded = java.net.URLEncoder.encode(name, "UTF-8");
  } 
  catch (Exception e) {
  }
  return encoded;
}

String removeQuotes(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == 34) {
      str = str.substring(1, str.length()-1);
    }
  }
  if (str.length() > 0) {

    if (str.charAt(str.length()-1) == 43) {
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}

String removeBrackets(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == '{') {
      str = str.substring(1, str.length()-1);
    }
  }
  if (str.length() > 0) {
    if (str.charAt(str.length()-1) == '}') {
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}