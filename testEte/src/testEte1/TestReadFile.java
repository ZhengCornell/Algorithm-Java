package testEte1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		String str = null;
		str = new TestReadFile().openFile();
			
	}

	private String openFile() throws FileNotFoundException,IOException {
		FileReader f =  new FileReader("/Users/Gz/Desktop/eclipse/testDate/src/calendar/VisualCalendar.java");
		return "1";
		
	}
}
