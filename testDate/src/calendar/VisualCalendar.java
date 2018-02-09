package calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisualCalendar {
	public static void main(String args[]){
		System.out.println("请输入日期:");
		Scanner s = new Scanner(System.in);
		String temp = s.nextLine();
		Way(temp);

	}
	public static void Way(String temp){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(date);
			int w = c.get(Calendar.DATE);
			c.set(Calendar.DATE,1);
			
			System.out.println(c.get(Calendar.DAY_OF_WEEK));
			System.out.println(c.getActualMaximum(Calendar.DATE));
			
			
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			int j = 0;
			for(int m = 0; m<(c.get(Calendar.DAY_OF_WEEK)-1); m++){
				System.out.print("\t");
			}
			for(int i = 1; i <= c.getActualMaximum(Calendar.DATE); i++){
				if(i == w){
					System.out.print(i+"*"+"\t");
					j++;
				}else{
				System.out.print(i+"\t");
				j++;}
				if(((j+c.get(Calendar.DAY_OF_WEEK))-1) % 7 == 0){
					System.out.println('\n');
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
