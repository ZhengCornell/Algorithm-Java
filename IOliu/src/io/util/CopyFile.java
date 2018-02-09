package io.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		String s = "/Users/Gz/Desktop/eclipse/IOliu/src/io/a.rtf";
		
		String d = "/Users/Gz/Desktop/eclipse/IOliu/src/io/c.rtf";
		copyFile(s,d);	
	}
		
////		1.建立联系(源文件存在)＋目的地（文件可以不存在）
//		File f = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/a.rtf");
//		File n = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/b.rtf");
////		2.选择流
//		InputStream is = new FileInputStream(f);
//		OutputStream os = new FileOutputStream(n);
////		3.文件拷贝 循环＋读取＋写出
//		byte[] flush = new byte[1024];
//		int len = 0;
//		while(-1 != (len = is.read(flush))){//读出来的东西放到len里
//			os.write(flush,0,len);
//		}
//		os.flush();//强制刷出
////		4.关闭流，先开后关
//		os.close();
//		is.close();
//	}
//	这就是个方法啊！
//	@param 原文件路径
//	@param 目标文件路径
//	@throws FileNotFoundException,IOException
//	@return
	
	
	
	
	
	
	
	
	
	
	public static void copyFile(String fPath,String dPath)	 throws FileNotFoundException,IOException {
//		1.建立联系(源文件存在)＋目的地（文件可以不存在）
		File f = new File(fPath);
		File n = new File(dPath);
//		2.选择流
		InputStream is = new FileInputStream(f);
		OutputStream os = new FileOutputStream(n);
//		3.文件拷贝 循环＋读取＋写出
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){//读出来的东西放到len里
			os.write(flush,0,len);
		}
		os.flush();//强制刷出
//		4.关闭流，先开后关
		FileUtilClose.close(os,is);//放在同一个包里才可以
	}
}
