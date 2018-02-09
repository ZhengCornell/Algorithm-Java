package io.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//发送数据线程
public class ThreadSend implements Runnable {
	//控制台输入流
	private BufferedReader br;
	//管道输出流
	private DataOutputStream dos;
	private boolean isRunning = true;
	private String name;
	
	public ThreadSend(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public ThreadSend(Socket client,String name){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
		} catch (IOException e) {
			this.isRunning = false;
			CloseUtil.closeAll(dos,br);
		}

	}
	private String getMsgFromBr(){
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	//从bw接受数据 再 发送数据
	public void send(String msg){
		
		if(null != msg && !msg.equals("")){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				this.isRunning = false;
			}
		}
	}
	
	

	@Override
	public void run() {
		while(isRunning){
			send(getMsgFromBr());
		}
		
	}

}
