package io.file;

import java.io.File;

//路径分割:
//名称文件分割\ /
public class Demo01 {
	public static void main(String args[]){
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		String path = "";
		path = ""+File.separator;//动态生成
		path = "/ / / ";//推荐
	}
}
 