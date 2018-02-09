package DIYLCL;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//自定义文件系统类加载器
public class FileSystemClassLoader extends ClassLoader{
//	bean.Hi ---------/Users/Gz/Desktop/testjava/bean/Hi.class
	private String rootDir;

	public FileSystemClassLoader(String rootDir) {
		super();
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
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
				byte[] classData = getClassData(name);//通过这个方法，内容进去返回字节数组
				if(classData==null){
					throw new ClassNotFoundException();
				}else{
					c = defineClass(name,classData,0,classData.length);
				}
			
			}
		}
		return c;
	}
	
	 private byte[] getClassData(String className){ //bean.Hi
		 String path = rootDir + "/" + className.replace('.','/')+".class";
		 //将文件中数据变为字节数组
		 InputStream is = null;
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 try {
			 is = new FileInputStream(path); 
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
