ArrayList<String> mails;
int mailIndex;

void initMail() {
}

void updateMail() {
	mails = new ArrayList();
	String[] mailBuffer = loadStrings("http://teleobjects.com/api/proxy.php?mail=true");
	for (int i=0; i<mailBuffer.length; i++) {
		mails.add(mailBuffer[i]);
		println(mailBuffer[i]);
	}


		// String[] items = splitTokens (mailBuffer[i], "\t");
		// String name = removeQuotes(items[0].substring(0, items[0].indexOf("<")));
		// mails.add(cleanUp(name.toUpperCase())+"\t"+SCROLL_CENTER+char(50)+char(50));
		// mails.add(cleanUp(items[1]+"\t"+INSTANT+char(32)+char(32)).toUpperCase());
		// String subject =  cleanUp(items[2].toUpperCase());
   //if (subject.length() > 32) {
   //  mails.add(subject.substring(0, 32)+"\t"+INSTANT+char(100)+char(100));
   //  mails.add(subject.substring(32, subject.length()-1)+"\t"+INSTANT+char(100)+char(100));
   //} else {
   //  mails.add(subject+"\t"+INSTANT+char(200)+char(100));
   //}
   //while (subject.length()>32) {
   //  mails.add(subject.substring(0, 32)+"\t"+INSTANT+char(100)+char(100));
   //  subject = subject.substring(32, subject.length());
   //}
   // mails.add(subject+"\t"+INSTANT+char(100)+char(100));

   //mails.add(" \t"+INSTANT+char(48)+char(48));

   //println(items[0].substring(0, items[0].indexOf('<')));
   //for (int j=1; j<items.length; j++) {
   //  mails.add(cleanUp(items[j], true));
   //}
// }
// }
}