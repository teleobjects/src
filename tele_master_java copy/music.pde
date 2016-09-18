

class Karaoke {

  String title;
  String artist;
  String file;
  String[] lyrics;
  ArrayList<String> lines;
  ArrayList<Integer> times;

  boolean playing;
  long startTime;
  int nextLine;
  int nextTime;

  Karaoke() {
    init();
  }

  void init() {
    file = "2 chainz wiz khalifa - we own it(fast&furious)";
    // file = "coldplay - yellow";
    // file = "daft punk - get lucky";
    lyrics = loadStrings("mp3/"+file+".lrc");
    lines = new ArrayList<String>();
    times = new ArrayList<Integer>();

    for (int i=0; i < lyrics.length; i++ ) {
      String thisLine = lyrics[i];
      if (thisLine.length()>9) {
        if (thisLine.charAt(0) == '[' && thisLine.charAt(3) == ':' && thisLine.charAt(6) == '.' && thisLine.charAt(9) == ']') {
          lines.add(thisLine.substring(10, thisLine.length()));
          times.add((parseInt(thisLine.substring(1, 3))*60*1000) + (parseInt(thisLine.substring(4, 6))*1000)  + parseInt(thisLine.substring(7, 9))*10);
          // println(thisLine.substring(1,3) + "  " + parseInt(thisLine.substring(1,3))*60*1000);
          // println(times.get(times.size()-1) + "\t\t\t"+ lines.get(lines.size()-1));
        }
      }
    }
  }

  void play() {
    if (!playing) {
      startTime = millis();
      playing = true;
    }
  }
  
  void stop(){
    playing = false; 
    
  }
  
  String update() {
    String result = "";
    if (playing) {
      if (times.get(nextLine) <= (millis() - startTime) ) {
        result = lines.get(nextLine);
        nextLine ++;
        if (nextLine == lines.size()) {
          println("end");
          playing = false;
          nextLine = 0;
          nextTime = 10;
        } else {
          nextTime = int((times.get(nextLine) - times.get(nextLine-1))/100);
        }
      }
    }
    return result;
  }
}