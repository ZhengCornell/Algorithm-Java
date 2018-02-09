package io.chario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//纯文本读取
public class Demo01Read {
	public static void main(String args[]){
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a.rtf");
		File dest = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/K.java");
//		System.out.println(dest.exists());
		Reader reader = null;
		try {
			reader = new FileReader(src);
			//读取 char[]
			char[] flush = new char[1024];
			int len = 0;
			while(-1 != (len = reader.read(flush))){
				String str = new String(flush, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭失败");
				}
			}
		}
		
	}
}
