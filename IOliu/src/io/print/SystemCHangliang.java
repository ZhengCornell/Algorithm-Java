package io.print;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//三个常量
//System.in 输入流 键盘输入 －－－》文件输入
//System.out 输出流 控制台输出---->文件输出
//System.err

//重定向 
//setIn
//setOut
//setErr
public class SystemCHangliang {

	public static void main(String[] args) throws FileNotFoundException {
//		test1();
//		test2();
		//重定向
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(src)),true));
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		//回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("GKF");
		
	}
	
	
	public static void test1(){
		System.out.println("test");
		System.err.println("test");
//		System.in.println("test");
	}


	public static void test2() throws FileNotFoundException{
		InputStream is = System.in;
		is = new BufferedInputStream(new FileInputStream("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a"));
		Scanner sc = new Scanner(is);
		System.out.println("test:");
		System.out.println(sc.nextLine());
	}

	



}
