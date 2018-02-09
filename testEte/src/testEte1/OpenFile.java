package testEte1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenFile {
	public static void main(String args[]){
		String str = new OpenFile().openFile();
		System.out.println(str);
	}
	String openFile(){
		try{
			System.out.println("1");
			FileInputStream fis = new FileInputStream("/Usedrs/Gz/Desktop/eclipse/testDate/src/calendar/VisualCalendar.java");
			int a = fis.read();
			System.out.println("2");
			return "diyib";
		}catch(FileNotFoundException e){
			System.out.println("3");
			e.printStackTrace();
			return "dierbu";	
		}catch(IOException e){
			System.out.println("4");
			e.printStackTrace();
			return "disanbu";
		}finally{
			System.out.println("5");

			
			
		}
	}
}
