package io.chat;
//接受数据线程

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadReceive implements Runnable{
	private DataInputStream dis;
	private boolean flag = true;
	public ThreadReceive(){
		
	}
	public ThreadReceive(Socket client){
	try {
		dis = new DataInputStream(client.getInputStream());
	} catch (IOException e) {
		this.flag = false;
		CloseUtil.closeAll(dis);
	}
	}
	public String receive(){
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			this.flag = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	
	@Override
	public void run() {
		while(flag){
			String str = receive();
			System.out.println(str);
		}
		
	}

}
