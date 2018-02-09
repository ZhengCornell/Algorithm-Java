package io;

import java.io.UnsupportedEncodingException;

public class BianJiema {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "中国";
		byte[] b = str.getBytes();
		b = str.getBytes("GBK");
		System.out.println(new String(b,"GBK"));
	}

}
