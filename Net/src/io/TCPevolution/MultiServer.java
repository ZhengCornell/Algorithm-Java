package io.TCPevolution;
//缺陷 只能接受一个客户端，如何改进
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	public static void main(String[] args) throws IOException {
//		1.创建服务器 serverSocket 指定端口
		ServerSocket server = new ServerSocket(7777); 
//		2.接受客户端的连接 阻塞式的 accept();
		while(true){	//此时死循环无限接受新的客户端
		Socket socket = server.accept();
		System.out.println("客户端1号建立连接");
//		3.发送接收数据（出 入）getInputStream
		String msg = "欢迎使用";

		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		}
		
		
		
//		获取输出流
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//		bw.write(msg);
//		bw.newLine();
//		bw.flush();
		
	}

}
