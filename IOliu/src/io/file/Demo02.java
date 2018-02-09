package io.file;

import java.io.File;

//相对路径、绝对路径 构造File
public class Demo02 {

	public static void main(String[] args) {
		String parentPath = "E:/xp/test";
		String name = "2.jpg";
		
		File src = new File(parentPath, name);//父路径＋相对路径
		src = new File(new File(parentPath), name);
		src = new File("E:/xp/test/3.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//若无盘符 以user.dir 构建 造在这个project里
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		
		
	}

}
