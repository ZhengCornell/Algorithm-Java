package io;

import java.io.File;
import java.io.IOException;

public class CopyDir {

	public static void main(String[] args) throws IOException {
	String srcPath = "/Users/Gz/Desktop/eclipse/IOliu/src/io/A";
	String destPath = "/Users/Gz/Desktop/eclipse/IOliu/src/io/AA";
	File src = new File(srcPath);
	File dest = null;
//	if(!dest.exists()){
//		dest.mkdirs();
//	}
	if(src.isDirectory()){
	dest = new File(destPath,src.getName());
	}
	
	copyDir(src,dest);

	
	}
	
	public static void copyDir(File src,File dest) throws IOException{
		if(src.isFile()){
			CopyByNode.copy(src,dest);
		}else if(!src.exists()){
			return;
		}else{
			dest.mkdirs();
//			File m = new File(dest,src.getName()); 
			for(File f:src.listFiles()){
			File k = new File(dest,f.getName());	
				copyDir(f,k);
			}
			
		}
		
	}

	



}
