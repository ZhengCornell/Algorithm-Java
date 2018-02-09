package io.chat;
//加入名称
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端可以发送数据（出） ＋ 接受数据（入）
//此时输入输出流在同一线程内

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("请输入名称：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals("")){
			return;
		}
		
		Socket client = new Socket("localhost",9999);
		//控制台输入
		
		ThreadSend ts = new ThreadSend(client,name);
		Thread t = new Thread(ts);
		t.start();
		
		ThreadReceive tr = new ThreadReceive(client);
		Thread t2 = new Thread(tr);
		t2.start();
		
//		while(true){
//		
//		//输出数据 dos
//	
//		//接受数据 dis
//		
//		}
	}

}
