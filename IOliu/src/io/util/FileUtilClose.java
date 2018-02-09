/**
 * 
 */
package io.util;

import java.io.Closeable;
import java.io.IOException;

/**工具类关闭流
 * @author Gz
 *
 */
public class FileUtilClose {
	
	
	
	public static void close(Closeable ... io){
		for(Closeable temp:io){
			if(null != temp){
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	


//	使用泛型
	public static <T extends Closeable> void closeAll(T...io){
		for(Closeable temp:io){
			if(null != temp){
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}



	
	
	
	