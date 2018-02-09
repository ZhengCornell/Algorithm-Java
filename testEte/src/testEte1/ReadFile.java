package testEte1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String args[]){
		FileReader r = null;
		try {
			r = new FileReader("/Users/Gz/Desktop/eclipse/testDate/src/calendar/VisualCalendar.java");
			char c = (char)r.read();
			char c2 = (char)r.read();
			System.out.println(""+c+c2);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				
			}
		}
		
		}
	}
