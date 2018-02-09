package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DIS {
	
	public static void main(String args[]) throws IOException{
//		write("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");	
//		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
//		read(src);
		
//		byte[] data = write();
//		read(data);
		read(write());
	}
	
	
	
	public static byte[] write() throws IOException{
		byte[] dest = new byte[1024];
		
		String name = "nihao";
		int a = 1;
		double b = 2.5;
//		File dest = new File(destPath);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		
		
		dos.writeUTF(name);
		dos.writeInt(a);
		dos.writeDouble(b);
		dos.flush();
		dest = baos.toByteArray();
		return dest;
	}


	public static void read(byte[] src) throws IOException{
		ByteArrayInputStream bais = new ByteArrayInputStream(src);
		DataInputStream dis = new DataInputStream(new BufferedInputStream(bais));
		String str = dis.readUTF();
		int a = dis.readInt();
		double b = dis.readDouble();
		System.out.println(b);
		
	}












}
