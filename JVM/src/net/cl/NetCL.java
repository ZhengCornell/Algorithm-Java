package net.cl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//网络系统类加载器
public class NetCL extends ClassLoader{
//	bean.Hi ---------/Users/Gz/Desktop/testjava/bean/Hi.class
	private String rootUrl;

	public NetCL(String rootUrl) {
		super();
		this.rootUrl = rootUrl;
	}

	@Override
	protected Class<?> findClass(String name) {
		//调用查找已加载的类 ，是否存在.若存在，则直接返回加载好的类
		Class<?> c = findLoadedClass(name);
		if(c!=null){
			return c;
		}else{//让一层层父类去找
			ClassLoader parent = this.getParent();
		try {
			c = parent.loadClass(name);//委派给父类
			} catch(Exception e){
//				e.printStackTrace();
			}
			if(c!=null){
				return c;
			}else{
				byte[] classData = new byte[1024];
				try {
					classData = getClassData(name);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//通过这个方法，内容进去返回字节数组
				if(classData==null){
					try {
						throw new Exception();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					c = defineClass(name,classData,0,classData.length);
				}
			
			}
		}
		return c;
	}
	
	 private byte[] getClassData(String className) throws Exception{ //bean.Hi
		 String path = rootUrl + "/" + className.replace('.','/')+".class";
		 //将文件中数据变为字节数组
		 InputStream is = null;
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 try {
			 URL url = new URL(path);
			 is = url.openStream();
			 byte[] flush = new byte[1024];
			 int len = 0;
			 try {
				while(-1 != (len = is.read(flush))){
					 baos.write(flush,0,len);
				 }
			} catch (IOException e) {
				e.printStackTrace();
			}
			 return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(null != baos){
				try {
					baos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	 }


}
