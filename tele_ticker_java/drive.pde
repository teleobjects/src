ArrayList drives;

void updateDrive() {
	drives = new ArrayList();
	long pingStart = millis();
	String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
	String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
	String[] driveContent = loadStrings(driveUrl);
	println(driveUrl);
	pingTime = int(millis()-pingStart);
	if (driveContent != null) {
		for (int i=0; i<driveContent.length; i++) {
			drives.add(removeQuotes(driveContent[i]));
		}
	}
}