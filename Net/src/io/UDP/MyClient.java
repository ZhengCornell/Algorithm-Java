package io.UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class MyClient {

	public static void main(String[] args) throws IOException {
//		1.创建客户端 ＋ 端口
		DatagramSocket client = new DatagramSocket(3333);
//		2.准备数据 剁成肉泥 一定要做成字节数组
//		String msg = "放fheo学";
//		byte[] data = msg.getBytes();
		double num = 89.12;
		byte[] data =convert(num);
		
		
//		3.打包 (指定数据发送地点以及端口)
//		DatagramPacket(数据，长度，服务端，端口)
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localHost",7777));
//		4.发送
		client.send(packet);
		client.close();
	}
	
	//字节数组 ＋ Data输出流
	public static byte[] convert(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data = bos.toByteArray();
		dos.close();
		
		
		return data;
	}

}
