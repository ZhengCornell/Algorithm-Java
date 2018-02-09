package io.file;

import java.io.File;
import java.util.Arrays;

//输出子孙目录、文件的名称
// listFiles 和 递归一起用
public class ZiSun {

	public static void main(String[] args) {
	String path = "/Users/Gz/Desktop/eclipse/IOliu";
	File parent =  new File(path);
	printName(parent);
//	File[] roots = File.listRoots();
//	System.out.println(Arrays.toString(roots));
//
	}
	
	
	
	
	
	public static void printName(File f){
		if(null ==f || !f.exists()){
			return;
		}
//		System.out.println(f.getAbsolutePath());
		if(f.isDirectory()){
			for(File k:f.listFiles())
			{
				printName(k);
//				if(1 > 0){
//					System.out.println(f.getAbsolutePath());
//				}
//				printName(k);
				String name = k.getName();
				if(!k.isDirectory() && name.endsWith(".java")){
				System.out.println(k.getAbsolutePath());
				}
			}
			
		
		}
	}








}
