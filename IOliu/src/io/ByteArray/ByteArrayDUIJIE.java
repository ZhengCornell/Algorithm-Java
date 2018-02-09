package io.ByteArray;
//文件－－－程序－－>字节数组
//文件输入流   字节数组输出流

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

//字节数组－－-程序－－>文件
//字节数组输入流  文件输出流
public class ByteArrayDUIJIE {

	public static void main(String[] args) throws IOException {
		byte[] data = getBytesFromFile("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		toFileFromByteArray(data,"/Users/Gz/Desktop/eclipse/IOliu/src/io/file/c");
		
		
		System.out.println(new String(data));

		

	}


	public static void toFileFromByteArray(byte[] src,String destPath) throws IOException{
		//创建源
		//目的地
		File dest = new File(destPath);
		//选择流
		//字节数组输入流 从管道中包装好了 放入 输入流当中
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流 写入文件
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//操作 不断读取字节数组 到文件中
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
//			不断 写入文件
			os.write(flush,0,len);
		}
		os.flush();
		os.close();
		is.close();
		
	}
	 
 	public static byte[] getBytesFromFile(String srcPath) throws IOException{
//		创建文件源
		File src = new File(srcPath);
//		创建目的地 字节数组
		byte[] dest = null;
//		选择流：文件输入流(使用缓冲流包装)
		InputStream is = new BufferedInputStream(new FileInputStream(src));
//		字节数组输出流 不能用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		操作 不断读取文件 写入字节数组
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
//			不断读取 写入字节数组流
			bos.write(flush,0,len);
		}
		bos.flush();
		
//		获取数据
		dest = bos.toByteArray();
		is.close();
		
		
		
		return dest;
	}

}
