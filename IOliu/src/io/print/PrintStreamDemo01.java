package io.print;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//PrintStream 打印流 也是一种处理流
public class PrintStreamDemo01 {
	public static void main(String args[]) throws FileNotFoundException{
		System.out.println("test");
		PrintStream ps = System.out;
		ps.println(false);
		
//		输出到文件
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("nmba");
		ps.close();
	
	
	}
}
