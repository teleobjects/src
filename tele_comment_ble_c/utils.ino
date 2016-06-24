
int findLastChar(String str, char c) {
  if (str.length() == 0) return 0;
  int count = str.length() - 1;
  while (count > 1) {
    if (str.charAt(count) == c) return count;
    count --;
  }
  return str.length() - 1;
}

int countChar(String str, char c) {
  if (str.length() == 0) return 0;
  int count = 0;
  for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == c) count ++;
  }
  return count;
}

String cleanString(String str) {
  String result = "";
  for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    switch (c) {
      case 176:
        result += char(142);
        break;
      default:
        result += c;
    }
  }
  return result;
}

