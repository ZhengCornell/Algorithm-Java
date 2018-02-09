package io.chat;
//先创建服务器
//这里的客户端存在了先后，需要引入多线程


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<MyChannel> all = new ArrayList<MyChannel>();
	
	
	public static void main(String args[]) throws IOException{
		Server s = new Server();
		s.start();
//		接受客户端数据
		
//		System.out.println(msg);
//		再把收到的msg输出
		}
	
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		while(true){
		Socket socket = server.accept();
		MyChannel m = new MyChannel(socket);
		Thread t = new Thread(m);
		all.add(m);//所有道路加入all容器中
		t.start();
		}
	}
	
	
	
	private class MyChannel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean flag = true;
		private String name;
		
		public MyChannel(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
//				System.out.println(this.name);
				this.send("欢迎进入聊天室");
				this.sendOthers(this.name+"进入了聊天室");
			} catch (IOException e) {
				CloseUtil.closeAll(dis,dos);
				this.flag = false;
				all.remove(this);
			}
		}
		private String receive(){
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				CloseUtil.closeAll(dis,dos);
				this.flag = false;
				all.remove(this);
			}
			return msg;
		}
		private void send(String msg){
			if(null == msg || msg.equals("")){
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				CloseUtil.closeAll(dis,dos);
				this.flag = false;
				all.remove(this);
			}
			}
		
		public void sendOthers(String msg){
//			String msg = receive();//数据获取
//			遍历容器
			for(MyChannel other:all){
				//发送给其他人
				other.send(msg);
			}
		}
		public void sendOthers1(String msg){
//			String msg = receive();//数据获取
//			是否为私聊
			if(msg.startsWith("@")&& msg.indexOf(":")>-1){//私聊
				//获取name 正文
				String name = msg.substring(1,msg.indexOf(":"));
				String content = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other:all){
					if(other.name.equals(name)){
						other.send(this.name+"对你悄悄说"+content);
						break;
					}else{
						other.send(this.name+"对所有人说"+msg);
					}
				}
			}
			
			else{
//			遍历容器
			for(MyChannel other:all){
				String str = this.name+"对所有人说：";
				//发送给其他人
				other.send(str+msg);
			}
			}
		}

		
		
		@Override
		public void run() {
			while(flag){
				sendOthers1(receive());
			}
				
			}
			
		}





}
	
//一个客户端

	
	
	
	
	
	
	
	
	
	
