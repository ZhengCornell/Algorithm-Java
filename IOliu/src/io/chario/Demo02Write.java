package io.chario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02Write {
	public static void main(String args[]){
		File dest = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		Writer wr = null;
		try {
			wr = new FileWriter(dest,false);
			String str = "你好";
			wr.write(str);
			wr.append("好他好他好他好他好我饭学他好");
			wr.flush();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(null != wr){
				try {
					wr.close();
				} catch (IOException e) {
					System.out.println("关闭失败");
					e.printStackTrace();
				}
			}
		}
		
	}
}
