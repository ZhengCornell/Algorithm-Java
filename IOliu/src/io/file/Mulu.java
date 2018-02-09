package io.file;
//mkdir  父目录不存在，创造失败
//list，列出所有的内部直接子文件

//mkdirs 父目录不存在，创造一个父目录
//拷贝
import java.io.File;
import java.io.FilenameFilter;


public class Mulu {

	public static void main(String[] args) {
		String path = "/Users/Gz/Desktop/eclipse/IOliu/src/io";
		File src = new File(path);
		if(src.isDirectory()){
//			System.out.println()
			String[] s = src.list();//输出子目录
			for(String temp:s){
				System.out.println(temp);
			}
			File[] f = src.listFiles();//输出子目录绝对地址
			for(File temp:f){
				System.out.println(temp);
			}
			//在子目录中寻找是否有符合条件的
			f = src.listFiles(new FilenameFilter(){

				@Override
//				dir 代表父目录
				public boolean accept(File dir, String name) {
//					System.out.println(dir.getAbsolutePath());
					return new File(dir,name).isFile() && name.endsWith(".java");
				}
				
			});
		}
		
//		src.mkdir();
//		src.mkdirs();
//	}
//	
//	public static test1(){
//		
//	}
}
}
