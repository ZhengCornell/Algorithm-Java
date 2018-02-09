package io.convert;

import java.io.UnsupportedEncodingException;

public class Jiema01 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "中国";
		byte[] data = str.getBytes();
		System.out.println(new String(data,0,5));
	}
	
	
	
	//编码解码集 不同的解决
	public static void test1() throws UnsupportedEncodingException{
//		解码（byte－－－char）;
		String str = "中国";
//		编码 字符（char）－－－字节二进制（byte）;
		byte[] data = str.getBytes();
		System.out.println(new String(data));
//		无乱码，因为编码解码字符集相同
//		尝试更换编码字符集，mac默认的是utf－8;
		data = str.getBytes("GBK");
		System.out.println(new String(data));
		//更换编码字符集 char－－byte
		byte[] data2 = str.getBytes("GBK");
		//更换解码字符集 byte －－char
		str = new String(data2,"GBK");
		System.out.println(str);
	}

}
