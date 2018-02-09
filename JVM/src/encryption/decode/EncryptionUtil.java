package encryption.decode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//加密工具类
public class EncryptionUtil {
	
	public static void main(String args[]) throws IOException{
		encrpt("/Users/Gz/Desktop/testjava/bean/d.java","/Users/Gz/Desktop/testjava/a.java");
		}
	
	public static void encrpt(String a, String b) throws IOException{
		File src = new File(a);
		File dest = new File(b);
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		int len = 0;
		while(-1 != (len = fis.read())){
			fos.write(len^0xff);
		}
		
		
		
		
		fis.close();
		fos.close();
	}
}
