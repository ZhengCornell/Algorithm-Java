package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bytenode {

	public static void main(String[] args) throws IOException {
//		read("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
	
		write("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
	}


	public static void read(String srcPath) throws IOException{
		File src = new File(srcPath);
		InputStream is = new FileInputStream(src);
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			String info = new String(flush,0,len);
			System.out.println(info);
		}
	}
	
	public static void write(String destPath) throws IOException{
		File dest =  new File(destPath);
		OutputStream os = new FileOutputStream(dest,true);
		String str = "你他妈";
		byte[] flush = str.getBytes();
		os.write(flush,0,flush.length);
		
	}




}	
	