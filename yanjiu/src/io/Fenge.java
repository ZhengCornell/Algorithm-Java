package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Fenge {
	private int size;//块数
	private long blockSize;//每块大小
	private String fileName;//每块名字
	private String srcPath;
	private List<String> blockPath;
	private long l;
	private String destBlockPath;
	
	
	
	
	public static void main(String args[]) throws IOException{
		Fenge src = new Fenge("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a",40);
//		System.out.println(src.size);
		src.fen("/Users/Gz/Desktop/eclipse/IOliu/src/io/file");
		
	}
//	public Fenge(){
//		destPath = new ArrayList<String>();	
//	}
	public Fenge(String srcPath,long blockSize){
		this(srcPath,1024,destBlockPath);
	}
		
	public Fenge(String srcPath, long blockSize,String destBlockPath){
		blockPath = new ArrayList<String>();
		this.srcPath = srcPath;
		this.blockSize = blockSize;
		this.destBlockPath = destBlockPath;
		inti(srcPath);
	}
//	public Fenge(){
//		destPath = new ArrayList<String>();	
//	}
	
	public Fenge(long blockSize, String srcPath) {
		super();
		this.blockSize = blockSize;
		this.srcPath = srcPath;
	}

	public void inti(String srcPath){
		File src = new File(srcPath);
//		File src = null;
		if(!src.exists()){
			return;
		}
		if(src.isDirectory()){
			return;
		}
		this.fileName = src.getName();
		this.l = src.length();//总长
		if(this.blockSize > l){
			this.blockSize = l;
		}
		size = (int) (Math.ceil(l*1.0/this.blockSize));
		intiFileName();
		
	}
	public void intiFileName(){
		for(int i = 0; i < size; i ++){
			this.blockPath.add(destBlockPath+"/"+this.fileName+".part"+i);
		}
	}
	
	
	public void fen(String destPath) throws IOException{
		long beginPoint = 0;
		long actualSize = this.blockSize;
		for(int i = 0; i < size - 1; i++){
			while(i == size -1){
			fengefangfa(i,beginPoint,this.l-actualSize*(size - 1));	
			}	
			fengefangfa(i,beginPoint,actualSize);
			beginPoint = beginPoint + actualSize;	
		}
		
	}
	public void fengefangfa(int i, long beginPoint, long actualSize) throws IOException{
		File src = new File(this.srcPath);
		File dest = new File(this.blockPath.get(i));
		RandomAccessFile raf = new RandomAccessFile(src,"r"); //输入
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest)); //输出
		raf.seek(beginPoint);	
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = raf.read(flush))){
			if(actualSize > len){
			bos.write(flush,0,len);
			actualSize = actualSize-len;
			}else{
				bos.write(flush,0,(int)actualSize);
				break;
			}
		}
		bos.flush();
		
	}
	
	
}
