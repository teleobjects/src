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

