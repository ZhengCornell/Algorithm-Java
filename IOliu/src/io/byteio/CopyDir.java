package io.byteio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//文件夹的拷贝
//1.遇到文件 就 copyFile
//2.遇到文件夹 就 mkdirs();
//3.查找子孙用递归。
//有个缺陷叫做无法把文件拷贝进已经存在的文件夹
public class CopyDir {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String sPath = "/Users/Gz/Desktop/eclipse/IOliu/src/io/A";
		String dPath = "/Users/Gz/Desktop/eclipse/IOliu/src/io/A/c";
		File src = new File(sPath);
		File dest = new File(dPath);
		FileUtilCopy.copyDir(sPath,dPath);
		
	}
	
	
	public static void copyDir(File src, File dest){
		if(src.isDirectory()){//是文件夹
			dest = new File(dest,src.getName());//建立父子关系
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("???");
				return;
			}
		}
		copyDirDetail(src,dest);
	}
	
	public static void copyDirDetail(File src, File dest){
		if(src.isFile()){//是文件，直接copy
			try {
				FileUtilCopy.copyFile(src,dest);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(src.isDirectory()){//文件夹
			//确保目标文件夹存在
			dest.mkdirs();//开始创建
			//遍历所有子孙级
			for(File f:src.listFiles()){
				copyDirDetail(f,new File(dest,f.getName()));
			}
		}
	}
	

}
