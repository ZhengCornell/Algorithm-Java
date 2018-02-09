/**
 * 
 */
package io.combind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Gz
 *拆分文件
 *1.分割的块数 size n 
 *2.每一块大小block
 *最后一块大小 总文件大小－（n－1）＊block；
 */
public class Demo01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
			RandomAccessFile rnd = new RandomAccessFile(new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a"),"r");
			rnd.seek(3);
			//定义缓冲大小
			byte[] flush = new byte[1024];
			int len = 0;
			
			while(-1 != (len = rnd.read(flush))){
				if(len >= 9){
					System.out.println(new String(flush,0,9));
					break;
				}else{
				System.out.println(new String(flush,0,len));
			}
			rnd.close();
			
	}

}
}