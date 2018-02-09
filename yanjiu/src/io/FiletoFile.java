package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FiletoFile {

	public static void main(String[] args) throws IOException {
		byte[] data = getBytesFromFile("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
//		System.out.println(new String(data));
		toFileFromBytes(data,"/Users/Gz/Desktop/eclipse/IOliu/src/io/file/m");
	}


	public static byte[] getBytesFromFile(String srcPath) throws IOException{//用文件输入流＋字节数组输出流
		File src = new File(srcPath);
		byte[] dest = new byte[1024]; 
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){//从is管道读出来，写进baos管道
			baos.write(flush,0,len);
		}
//		从baos管道放入字节数组 dest 中
		dest = baos.toByteArray();
		return dest;
	}



	public static void toFileFromBytes(byte[] src,String destPath) throws IOException{//用字节输入流＋文件输出流
//		创建目的地文件和源数组
		File dest = new File(destPath);
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(
						src)
				);
		OutputStream os = new BufferedOutputStream(
				new FileOutputStream(dest)
				);	
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			os.write(flush, 0, len);
		}
		os.flush();
		
	}


}
