package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharNode {
	public static void main(String args[]) throws IOException{
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
//		read(src);
		File dest = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/b");
//		write(dest);
		copy(src,dest);
	}
	
	
	public static void read(File src) throws IOException{
		Reader r = new BufferedReader(new FileReader(src));
		char[] flush = new char[1024];
		int len;
		while(-1 != (len = r.read(flush))){
			String info = new String(flush,0,len);
			System.out.println(info);
		}
		
	}
	
	public static void write(File dest) throws IOException{
		Writer w = new BufferedWriter(new FileWriter(dest,false));
		String str = "我是你爸爸";
		w.write(str);
		w.flush();
	}
	
	public static void copy(File src, File dest) throws IOException{
		Reader r = new BufferedReader(new FileReader(src));
		char[] flush = new char[1024];
		int len;
		Writer w = new BufferedWriter(new FileWriter(dest,false));
		String l = null;
		while((l = r.readLine())!=null){
			w.write(l);
			w.newLine();
			
		}
//		while(-1 != (len = r.read(flush))){
//			String info = new String(flush,0,len);
//			w.write(info);
//			w.flush();
//		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
