
package test;

import java.util.Date;

public class TestDate {
	public static void main(String args[]){
		Date d = new Date();
		long t = System.currentTimeMillis();
		System.out.println(t);
		Date d2 = new Date(1000);
		d2.setTime(10000);
		Date d3 = new Date(100000);
		System.out.println(d2.before(d));
		System.out.println(d2.toString());
		System.out.println(d2.toGMTString());
		System.out.println(d2.getTime());
		
		
	}

}