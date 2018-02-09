package io.CHULI;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectDemo01 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		try {
			seri("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		read("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");

	}
	
	//反序列化，把对象输入读入
	public static void read(String destPath) throws IOException, ClassNotFoundException{
//		创建源 选择流
		File src = new File(destPath);
		ObjectInputStream dis = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
//		操作 读取的顺序和写的（已存在）顺序相同 2个要求 
		Object obj = dis.readObject();
		if(obj instanceof Employee){
			Employee emp = (Employee) obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			
		}
		obj = dis.readObject();
		int[] a = (int[]) obj;
		System.out.println(Arrays.toString(a));
 		
		dis.close();
		
	}
	
	
	
	
	
	//序列化，把对象输出写出
	public static void seri(String destPath) throws FileNotFoundException, IOException{
		Employee emp = new Employee("gz",1000);
		int[] a ={1,2,3,4,5,6};
//		创建源文件地址
		File dest = new File(destPath);
//		选择流
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作写的顺序 为读取准备
		dos.writeObject(emp);
		dos.writeObject(a);
		dos.close();
	}
	






}
