package io.file;

import java.io.File;
import java.io.IOException;

//读取信息，读取的是属性 位置大小创建时间等
public class Fangfa {

	public static void main(String[] args) {
		try {
			try {
				test3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			try {
//				test4();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	public static void test3() throws IOException, InterruptedException{
		String path = "/Users/Gz/Desktop/eclipse/IOliu/src/io/file/k.java";
		File src = new File(path);
		if(!src.exists()){
			boolean flag = src.createNewFile();
			System.out.println(flag?"nb":"gg");
		}
		boolean flag = src.delete();
		System.out.println(flag?"nb":"gg");
	File temp = File.createTempFile("tes",".java",new File("/Users/Gz/Desktop/eclipse"));
	Thread.sleep(10000);
	temp.deleteOnExit();
	
	}
	
	public static void test2(){
		String path = "/Users/Gz/Desktop/eclipse/IOliu/src/io/file/Fangfa.java";
		File src = new File(path);
		System.out.println(src.exists());
		System.out.println(src.canWrite());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		System.out.println(src.isAbsolute());
		System.out.println(src.length());//文件夹长度读不出来
	}
	
	//静态方法，创建临时文件
	
//	public static void test4() throws IOException, InterruptedException{
//		File t = File.createTempFile("kl",".temp",new File("/Users/Gz/Desktop"));
//		Thread.sleep(1000);
//		t.deleteOnExit();
//		
//	}
}
