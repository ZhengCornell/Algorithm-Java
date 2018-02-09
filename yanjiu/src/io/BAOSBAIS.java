package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BAOSBAIS {

	public static void main(String[] args) throws IOException {
		read(write());
		

	}
	
	
	
	public static void read(byte[] b) throws IOException{//BAIS
//		ByteArrayInputStream bais = new ByteArrayInputStream(data);
//		String str = "中国";
//		byte[] data = str.getBytes();
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(
						b
						)
				);
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			String info = new String(flush,0,len);
			System.out.println(info);
		}
	}
	
	public static byte[] write(){//都是手动写入写出的
		//用字节数组包数据
		byte[] dest = new byte[1024];
//		选择流不同！！！
//		OutputStream os = new BufferedOutputStream(
//				 new ByteArrayOutputStream(
//						dest
//						)
//				);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String str = "爸爸";
		byte[] b = str.getBytes();
		bos.write(b,0,b.length);
		dest = bos.toByteArray();
		
		return dest;
		
	
	}

}
