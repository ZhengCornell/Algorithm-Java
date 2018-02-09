package io.ByteArray;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

//字节数组节点流
//输入流 操作与文件读取一致;输出流 操作与文件输出不完全相同
//读取字节数组
//数组长度有限，数据量不会很大
public class ByteArrayJIEDIAN {

	public static void main(String[] args) throws IOException {
		read(write());
	}



	public static byte[] write() throws IOException{
//		目的地
		byte[] dest;
//		选择流 不同！
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		写出 写进了bos管道中
		String msg = "//数组长度有限，数据量不会很大";//这是文件！！！
		byte[] info = msg.getBytes();
		bos.write(info, 0, info.length);
//		获取数据
		dest = bos.toByteArray();
//		关闭
		bos.close();
		return dest;
		
		
	}
	public static void read(byte[] src) throws IOException{
//		数据源存入
//		String msg = "输入流 操作与文件读取一致";
//		byte[] src = msg.getBytes();
//		选择流
		InputStream is = new BufferedInputStream(
				new ByteArrayInputStream(
						src
						)
				);
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){
			System.out.println(new String(flush,0,len));
		}
		is.close();
	}




}
