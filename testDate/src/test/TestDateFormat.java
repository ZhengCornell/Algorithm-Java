package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String agrs[]){
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss 本年第W，本月第w");//抽象类不能建，找子类//
	
	Date d = new Date(122398423213123L);
	String str = df.format(d);
	System.out.println(str);
	
	
	String str2 = "1997-04-04";
	DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
	try {
		Date d2 = df2.parse(str2);
		System.out.println(d2);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
