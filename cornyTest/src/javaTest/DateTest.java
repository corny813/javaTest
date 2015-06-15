package javaTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {

	public static void main(String args[]){
		DateTest test = new DateTest();
		test.getDateByDay();
	}
	
	public void getDateByDay(){
		
		//replaced by Calendar
		Date date = new Date();
		date.getDay();
		
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		date = calendar.getTime();	//Wed Jan 28 11:24:38 CST 2015
		calendar.getTimeInMillis();	 //1422415605283
		calendar.getTimeZone();	 //sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null]
		
		int day_of_month = calendar.get(Calendar.DAY_OF_MONTH);	//28
		System.out.println(day_of_month);  
		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);	//4
		System.out.println(day_of_week);
		
	}
}
