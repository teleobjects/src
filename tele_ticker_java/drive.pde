ArrayList drives;

void updateDrive() {
  drives = new ArrayList();
  String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
  String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
  String[] driveContent = loadUrl(driveUrl);
  if (driveContent != null) {
    for (int i=0; i<driveContent.length; i++) {
      drives.add(removeQuotes(driveContent[i]));
    }
  }
}