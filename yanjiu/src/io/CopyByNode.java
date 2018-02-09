package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyByNode {

	public static void main(String[] args) throws IOException {
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		File dest = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/b");
		copy(src,dest);
	}




	public static void copy(File src,File dest) throws IOException{
		
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		byte[] flush = new byte[1024];
//		byte[] b = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			String info = new String(flush,0,len);
			byte[] b = info.getBytes();
			os.write(b,0,b.length);
			
//			System.out.println(info);
		}
		
	}




}
