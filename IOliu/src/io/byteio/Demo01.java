package io.byteio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//文件读取
public class Demo01 {

	public static void main(String[] args) {
//		1.建立联系
		File f = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/a");
//		2.选择流
		InputStream is = null;
		try {
			is = new FileInputStream(f);
//			3.操作（不断读取）循环读取
			byte[] car = new byte[1000];//需要一个缓冲
			int len = 0; //实际读取数量初值
			while(-1 != (len = is.read(car))){
				//输出：字节数组转为字符串
				String info = new String(car,0,len);
				System.out.println(info);
			}
			} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
			} catch (IOException e) {
	 System.out.println("读取文件失败");
			e.printStackTrace();
			} finally{
//				释放资源
				if(null != is){
					try {
						is.close();
					} catch (IOException e) {
					System.out.println("关闭失败");
						e.printStackTrace();
					}
				}
			}
		
				
	}

}
