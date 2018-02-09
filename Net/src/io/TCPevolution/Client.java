package io.TCPevolution;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//创建客户端 必须指定服务器端＋端口，这样就连接上了
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
//		1.创建客户端(无需手写客户端端口，自动分配)
		Socket client = new Socket("localhost",7777);
//		2.接受发送数据（入 出）都用字符
//		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
//		String echo = br.readLine();
//		System.out.println(echo);
	
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String echo = dis.readUTF();
		System.out.println(echo);
	
	}

}