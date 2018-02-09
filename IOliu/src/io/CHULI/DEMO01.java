/**
 * 
 */
package io.CHULI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**数据类型 基本类型 ＋ String  输出 到文件，再从文件中读取
 * @author Gz
 *输入流
 *输出流
 *新增方法不能使用多态
 */
public class DEMO01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		write("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		read("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
	}
	public static void read(String destPath) throws IOException{
//		创建源 选择流
		File src = new File(destPath);
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
//		操作 读取的顺序和写的（已存在）顺序相同 2个要求 
		double num1 = dis.readDouble();
		long num2 = dis.readLong();
		String str = dis.readUTF();
		System.out.println(num1+"----"+num2+"----"+str);
		
	}

	
	
	public static void write(String destPath) throws IOException{
		double point = 2.5;
		long num = 100L;
		String str = "nihao";
//		创建源文件地址
		File dest = new File(destPath);
//		选择流
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作写的顺序 为读取准备
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dos.close();
	}
}
