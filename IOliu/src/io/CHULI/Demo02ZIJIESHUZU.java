/**
 * 
 */
package io.CHULI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**数据类型 基本类型 ＋ String  输出 到字节数组，再从文件中字节数组
 * @author Gz
 *
 */
public class Demo02ZIJIESHUZU {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		byte[] data = write();
		System.out.println(data.length);
		read(data);

	}
	
	
	
	
	public static void read(byte[] src)throws IOException{
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				);
//		处理
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		dis.close();
		System.out.println(num1+"----"+num2+"----"+str);
	}


	public static byte[] write() throws IOException{
//		创建目标数组
		byte[] dest = null;
		double point = 2.5;
		long num = 100L;
		String str = "nihao";
//		选择流 字节数组输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						baos
						)
				);
		//操作写的顺序 为读取准备
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dest = baos.toByteArray();
		dos.close();
		return dest;
	}
}
