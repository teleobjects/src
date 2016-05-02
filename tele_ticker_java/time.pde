import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

String dayStr, monthStr;
int day;
int month;
int year;
long startTime = 0;
long currentTimeStamp = 0;
long startTimeStamp = 0;

String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
String[] monthNames ={"January", "February", "March", "April", "May", "June", "July", 
"August", "September", "October", "November", "December"};

void initTime() {
  Date d = new Date();
  startTimeStamp = d.getTime();
  Calendar cal = Calendar.getInstance();
  cal.setTime(d);
  int dayTemp = cal.get(Calendar.DAY_OF_WEEK);
  dayTemp -= 2;
  if (dayTemp < 0)dayTemp += 7;
  dayStr = dayNames[dayTemp];
  day = cal.get(Calendar.DAY_OF_MONTH);
  month = cal.get(Calendar.MONTH);
  monthStr = monthNames[month];
  year = cal.get(Calendar.YEAR);
  startTime = millis();
}

void updateTime() {
  Date d = new Date();
  currentTimeStamp = d.getTime();
}

