char DOUBLE_QUOTE = 34;

String concatenate(String[] content) {
  String result="";
  for(int i=0; i<content.length;i++){
    result += content[i];
  }
  return result;
}

int countChar(String str, char c){
  if (str.length() == 0 || str == null) return 0;
  int count = 0;
  for (int i=0; i<str.length(); i++) {
    if(str.charAt(i) == c) count ++;
  }
  return count;
}

int findLastChar(String str, char c) {
  if (str.length() == 0 || str == null) return 0;
  int count = str.length() - 1;
  while (count > 0) {
    if (str.charAt(count) == c) break;
    count --;
  }
  return count;
}

String removeQuotes(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == DOUBLE_QUOTE) {
      str = str.substring(1, str.length());
    }
  }
  if (str.length() > 0) {

    if (str.charAt(str.length()-1) == DOUBLE_QUOTE) {
      str = str.substring(0, str.length()-1);
    }
  }
  return str;
}

String removeSpaces(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == ' ') {
      str = str.substring(1, str.length());
    }
  }
  if (str.length() > 0) {
    if (str.charAt(str.length()-1) == ' ') {
      str = str.substring(0, str.length()-1);
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

String encode(String name) {
  String encoded = null;
  try { 
    encoded = java.net.URLEncoder.encode(name, "UTF-8"); 
  } catch (Exception e) {

  }
  return encoded;
}

String getHeading(float deg) {
  String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", 
  "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
  int i = int((deg + 11.25)/22.5);
  return directions[i % 16];
}

String getCoordinate(double coordinate, boolean isLat) {
  char hemisphere = coordinate < 0 ? (isLat ? 'S' : 'W') : (isLat ? 'N' : 'E');
  float coord = (float)coordinate; 
  coord = abs(coord);
  int degrees = int(coord);         
  float minutesFromRemainder = (coord - degrees) * 60;      
  int minutes = int(minutesFromRemainder);      
  float secondsFromRemainder = ( minutesFromRemainder - minutes ) * 60;  
  int seconds = int( secondsFromRemainder);
  return (degrees+"°" + nf(minutes, 2, 0) + "'" + nf(seconds, 2, 0) + DOUBLE_QUOTE +""+hemisphere);
}

float getCelcius(float temp) {
  temp -= 32;
  temp /= 1.8;
  return temp;
}

String getStringDate(String separator) {
  String result = "";
  String day_ = nf(time.day, 2, 0);
  String month_ = nf(time.month, 2, 0);
  String year_ = (""+time.year);//.substring(2,4);
  result += month_;
  result +=  separator;
  result += day_;
  result +=  separator;
  result += year_;
  return result;
}

String getStringTime(boolean am_pm, String separator) {
  String result = "";
  if (am_pm) {
    String hour_ = nf(hour()%12, 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  separator;
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += separator;
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
    if (hour() >= 12) {
      result += " PM";
    } else {
      result += " AM";
    }
  }   else {
    String hour_ = nf(hour(), 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  ". ";
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += ". ";
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
  }
  return result;
}


float attract(float val, float target, float ratio, float snap) {
  float result =  val + ((target-val)*ratio);
  if (abs(result-target) < snap) result = target;
  return result;
} 


