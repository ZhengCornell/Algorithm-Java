package io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//转换流：字节转换字符
//输出流 OutputStreamWriter 编码
//输入流 InputStreamReader 解码
public class bytetochar {

	public static void main(String[] args) throws IOException {
		//这种操作指定不了字符集，所以用底层使用字节流解码，但不能直接转换
		//用转换流解码
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(
						new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a")
						)
				,"UTF-8"
				)
	 	);
		//此时可以写出
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
				new FileOutputStream(
						new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/b")
						)
				,"UTF-8"
				)
	 	);
		
		char[] flush = new char[1024];
		int len = 0;
		while(-1 != (len = br.read(flush))){
			bw.write(flush, 0, len);
		}
		bw.flush();
		if(null != bw){
			bw.close();
		}
		if(null != br){
			br.close();
		}
//		String info = null;
//		while(null != (info = br.readLine())){
//			System.out.println(info);
//		}
//		br.close();

	}

}
