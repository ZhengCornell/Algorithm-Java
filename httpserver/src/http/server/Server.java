package http.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//创建服务器并启动
public class Server {
	private ServerSocket server;
	public static void main(String[] args) {
		Server s = new Server();
		s.start();
		
		s.stop(); 
	}

//启动方法
	public void start(){
		 try {
			server = new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
//接受客户端方法	
	private void receive(){
		try {
			Socket client = server.accept();
			StringBuilder sb = new StringBuilder();
			String msg = null;//接收客户端请求信息
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg = br.readLine()).length() > 0){
				sb.append(msg);
				sb.append("\r\n");
				if(null == msg){
					break;
				}
				String requestInfo = sb.toString().trim();
				System.out.println(sb.toString());
			}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//停止方法
	public void stop(){
		
		
	}
	
}
