package file;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String args[]){
		File f = new File("//Users/Gz/Desktop/eclipse/testDate/src/calendar/VisualCalendar.java");
//可以代表目录或者具体文件
		File f2 = new File("/Users/Gz/Desktop/eclipse/testDate/src/calendar");
		File f3 = new File(f2,"VisualCalendar.java");
		File f4 = new File(f2,"TestFile666.java");
		File f5 = new File("/Users/Gz/Desktop/Eclipse/nimabi/wocao");
		f5.mkdirs();
		try {
			f4.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(f.isFile()){
			System.out.println("shiwenjian");
		}
		if(f.isDirectory()){
			System.out.println("shimulu");
		}
	}
}
