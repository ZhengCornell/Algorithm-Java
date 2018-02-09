package io.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {
//	文件路径
	private String filePath;
//	文件名
	private String fileName;
//	块数
	private int size;
//	每块的大小
	private long blockSize;
//	每块的名称
	private List<String> blockPath;
//	总长度
	private long length;
//	分割后的存放目录
	private String destBlockPath;
	
	
	public SplitFile(){
		blockPath = new ArrayList<String>();
	}
	public SplitFile(String filePath,String destBlockPath){
		this(filePath,1024,destBlockPath);
		
	}
	public SplitFile(String filePath,long blockSize,String destBlockPath){
		this();
		this.filePath = filePath;
		this.blockSize = blockSize;
		this.destBlockPath = destBlockPath;
		inti();
	}
	
//	初始化操作，计算块数，确定文件名
	public void inti(){
		File src = null;
		//健壮性
		if(null == filePath||!(src = new File(filePath)).exists()){
			return;
		}
		if(src.isDirectory()){
			return;
		}
		this.fileName = src.getName();
		//实际大小
		this.length = src.length();
		if(this.blockSize > length){
			this.blockSize = length;//直接修正
		}
		size = (int) (Math.ceil(length*1.0/this.blockSize));
		initPathName();
	}
	private void initPathName(){
		for(int i = 0; i < size; i++){
			this.blockPath.add(destBlockPath+"/"+this.fileName+".part" + i);
		}
	}
//	文件分割 分割文件的存放目录设定好
//	起始位置 实际大小 确定在第几块
	public void split(String destPath) throws IOException{
		
		long beginPos = 0;
		long actualBlockSize = blockSize;
	
		
		for(int i = 0; i < size; i++){
			if(i == size - 1){//最后一块
				actualBlockSize = this.length - beginPos;
			}
			splitDetail(i,beginPos,actualBlockSize);
			beginPos += actualBlockSize;
		}
	}
	//文件分割 输入 输出 ，文件的拷贝
	public void splitDetail(int idx, long beginPos, long actualBlockSize) throws IOException{
		//创建源 多个目标
		File src = new File(this.filePath);
		File dest = new File(this.blockPath.get(idx));
		//选择流
		RandomAccessFile raf = null;
		BufferedOutputStream bos = null;
		try {
			raf = new RandomAccessFile(src,"r");
			bos = new BufferedOutputStream(new FileOutputStream(dest));
		
//			读取文件
			raf.seek(beginPos);
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len = raf.read(flush))){
				
				if(actualBlockSize - len >=0){
					bos.write(flush,0,len);
					actualBlockSize -= len;
				}else{//不够减了，字节写出最后剩余量
					bos.write(flush,0,(int)actualBlockSize);
					break;
				}
			}
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			bos.close();
			raf.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		SplitFile file = new SplitFile("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a",20,"/Users/Gz/Desktop/eclipse/IOliu/src/io/file");
//		file.split("/Users/Gz/Desktop/eclipse/IOliu/src/io/file");
	
//		file.mergeFile("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/k");
		
	}
	
	
//	文件合并 不断追加
	public void mergeFile(String destPath) throws IOException{
		File dest = new File(destPath);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		bos = new BufferedOutputStream(new FileOutputStream(dest,true));//追加
		for(int i = 0; i < this.blockPath.size();i++){
			bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))); 
			byte[] flush = new byte[1024];
			int len = 0;
			while(-1 != (len = bis.read(flush))){
				System.out.println(new String(flush,0,len));
				bos.write(flush,0,len);
			}
			bos.flush();
			bis.close();
		
		
		}
		bos.close();
		
	}








}
