package io.byteio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//写出文件
public class Xiechu {

	public static void main(String[] args) {
//		1.建立联系
		File f = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/a.rtf");
//		System.out.println(f.exists());
//		2.选择流
		OutputStream os = null;
//		3.以追加形式写出文件
		try {
			os = new FileOutputStream(f,true);
//		4.写出内容	
			String str = "i am your dad \r\n";
//		5.字符串转字节数组	
			byte[] data = str.getBytes();
			os.write(data);
//		6.强制刷新出去
			os.flush();
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("文件写出失败");
			e.printStackTrace();
		} finally{
			if(null != os){
				try {
					os.close();
				} catch (IOException e) {
					System.out.println("关闭输出流失败");
					e.printStackTrace();
				}
			}
		}
	
	
	
	
	
	
	}

}
