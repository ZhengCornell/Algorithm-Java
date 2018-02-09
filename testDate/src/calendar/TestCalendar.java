package calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String args[]){
		Calendar c = new GregorianCalendar();
//		c.set(2001,Calendar.FEBRUARY,10,12,23,34);
		c.set(Calendar.YEAR,2001);
//		c.set(Calendar.MONTH, Calendar.FEBRUARY);//其他数据继承当前情况
		c.setTime(new Date(1000));
//		Date d = c.getTime();
		c.add(Calendar.YEAR,-30);
		
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.YEAR));
		
	}
}
