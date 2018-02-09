package io.UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//先打开服务端
public class MyServer {

	public static void main(String[] args) throws IOException {
//		1.创建服务端＋端口
		DatagramSocket server = new DatagramSocket(7777);
//		2.准备接收容器
		byte[] container = new byte[1024];
//		3.封装容器
		DatagramPacket packet = new DatagramPacket(container,container.length);
//		4.接受数据
		server.receive(packet);
//		5.分析数据
		byte[] data = packet.getData();
		double num = convert(data);
		System.out.println(num);
//		6.释放资源
		server.close();
		
	
	
	}
	
	public static double convert(byte[] data) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(bis);
		double num = dis.readDouble();
		dis.close();
		return num;
	}

}
