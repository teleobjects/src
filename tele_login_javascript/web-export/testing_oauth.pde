void setup() {
  String[] result= loadStrings("http://www.teleobjects.com/api/auth.php");

  //String[] more= loadStrings("https://accounts.google.com/o/oauth2/auth?response_type=code&redirect_uri=http%3A%2F%2Fwww.teleobjects.com%2Fapi%2Fdrive.php&client_id=113132524761-9vc5rqbcbqjq79msolp7iaki9vbehqsl.apps.googleusercontent.com&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile+http%3A%2F%2Fwww.google.com%2Fm8%2Ffeeds%2F+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive+https%3A%2F%2Fspreadsheets.google.com%2Ffeeds&access_type=offline&approval_prompt=auto&include_granted_scopes=true");
  println(result);
}

void draw() {
  
}
