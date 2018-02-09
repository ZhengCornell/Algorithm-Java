package linkedlist;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		long d = System.currentTimeMillis();
		long a = 0;
		for(long i = 0; i < 100000000; i++){
			a += i;
		}
		long d2 = System.currentTimeMillis();
		System.out.println(d2-d);//T = aN^3;
	
	}
}