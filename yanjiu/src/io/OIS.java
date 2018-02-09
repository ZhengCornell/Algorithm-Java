package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OIS {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		write("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
		read(src);
	}






	public static void write(String destPath) throws FileNotFoundException, IOException{
		Employee emp = new Employee("gz",1000);
		File dest = new File(destPath);
		ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
		dos.writeObject(emp);
		dos.flush();
		dos.close();
	}
	
	public static void read(File src) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(src)));
		Object obj = ois.readObject();
		if(obj instanceof Employee){
			Employee emp = (Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
			
		}
		
	}



}
