ArrayList<String> news;

ArrayList<Article> articles;
int articleIndex;

PImage articleImage;

// import java.net.URI;
String newsKey = "df5b7c70d8675c367c0cbacc5b8879e0:11:74861169";

void initNews() {
}

void updateNews() {
  news = new ArrayList();
  articles = new ArrayList();
  articleIndex = 0;
  news.add(createString("LATEST FROM NY TIMES", SCROLL_PUSH_RIGHT, 10, 1, 20));
  news.add(createString(" ", SCROLL_PUSH_RIGHT, 10, 1, 10));
  String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
  String[] newsResponse = loadUrl(newsUrl);
  // println(newsUrl);
  if (newsResponse != null) {
    String newsFragment = newsResponse[0];
    processing.data.JSONObject newsJSON = processing.data.JSONObject.parse(newsFragment);
    processing.data.JSONArray newsArray = newsJSON.getJSONArray("results");
    int numberOfNews = newsArray.size();
    for (int i=1; i<numberOfNews; i++) {
      processing.data.JSONObject newsContent = newsArray.getJSONObject(i);
      String newsTitle = newsContent.getString("title");
      String newsSection = newsContent.getString("section");
      String newsKeywords = newsContent.getString("adx_keywords");
      String newsAbstract = newsContent.getString("abstract");
      String newsType = newsContent.getString("section");

      processing.data.JSONArray mediaArray = newsContent.getJSONArray("media");
      processing.data.JSONObject mediaContent = mediaArray.getJSONObject(0);

      processing.data.JSONArray mediaMetadataArray = mediaContent.getJSONArray("media-metadata");
      processing.data.JSONObject imageData = mediaMetadataArray.getJSONObject(0);
      String imageUrl = imageData.getString("url");
      // println(imageUrl);

      String items[] = splitTokens(cleanUp(newsKeywords, true), ";");
      int count = 0;

      Article article = new Article();
      article.imageUrl = imageUrl;
      article.title = newsTitle;
      article.content = newsAbstract;
      for (int j=0; j<items.length && count < 5; j++) {
        if (items[j].length() < 28) {
          String keyword = cleanKeyword(items[j]);
          if (keyword != null && keyword.length() >0 ) {
            count ++;
            article.keywords.add(keyword);
            println(keyword);
          }
        }
      }
      if (article.keywords.size() > 0) {
        article.display();
      }
    }
  }
  if (news.size() == 0) news.add("CAN'T CONNECT TO NY TIMES");
}

class Article {
  String title;
  String content;
  ArrayList<String> keywords;
  String imageUrl;

  Article() {
    keywords = new ArrayList();
  }

  void display() {
    //news.add(createString("NEWS|"+title+"|"+imageUrl, DWEET_TX, 1, 1, 1));
    for (String keyword : keywords) {
      //news.add(createString("", BLANK, 1, 1, 1));
      news.add(createString(keyword, CENTERED, 1, 1, 5));
    }
    news.add(createString("", BLANK, 1, 1, 1));
    news.add(createString(cleanUp(title, true), TICKER, 2, 10, 30));
    news.add(createString(cleanUp(content, true), TICKER, 2, 10, 50));
    news.add(createString("", BLANK, 1, 1, 1));
  }
}

String cleanKeyword(String str) {
  int parenthesis = str.indexOf("(");
  if (parenthesis != -1) {
   str = removeSpaces(str.substring(0, parenthesis-1));
  }
  int comma = str.indexOf(",");
  if (comma != -1) {
    str = str.substring(comma+1, str.length())+" "+removeSpaces(str.substring(0, comma));
  }

  return removeSpaces(str);
}