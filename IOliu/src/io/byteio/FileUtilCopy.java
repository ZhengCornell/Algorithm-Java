package io.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtilCopy {
	public static void copyFile(String fPath,String dPath)	 throws FileNotFoundException,IOException {
//		1.建立联系(源文件存在)＋目的地（文件可以不存在）
//		File f = new File(fPath);
//		File n = new File(dPath);
		copyFile(new File(fPath), new File(dPath));
////		2.选择流
//		InputStream is = new FileInputStream(f);
//		OutputStream os = new FileOutputStream(n);
////		3.文件拷贝 循环＋读取＋写出
//		byte[] flush = new byte[1024];
//		int len = 0;
//		while(-1 != (len = is.read(flush))){//读出来的东西放到len里
//			os.write(flush,0,len);
//		}
//		os.flush();//强制刷出
////		4.关闭流，先开后关
//		os.close();
//		is.close();
	}
	public static void copyFile(File src, File dest) throws FileNotFoundException,IOException {
//		1.建立联系(源文件存在)＋目的地（文件可以不存在）
//		File f = new File(fPath);
//		File n = new File(dPath);
//		2.选择流
		//如果dest已经存在文件夹，不能建立与dest同名文件夹
		if(dest.isDirectory()){
//			System.out.println("不能建立与文件夹同名的文件");
			throw new IOException("不能建立与文件夹同名的文件");
		}
		
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
//		3.文件拷贝 循环＋读取＋写出
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))){//读出来的东西放到len里
			os.write(flush,0,len);
		}
		os.flush();//强制刷出
//		4.关闭流，先开后关
		os.close();
		is.close();
	}
	public static void copyDir(String sPath, String dPath){
		
		copyDir(new File(sPath), new File(dPath));
	}
	
	public static void copyDir(File src, File dest){
		if(src.isDirectory()){//是文件夹
			dest = new File(dest,src.getName());//建立父子关系
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
