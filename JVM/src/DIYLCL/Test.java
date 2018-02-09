package DIYLCL;
//测试自定义的FileSystemClassLoader
public class Test {
	public static void main(String args[]) throws Exception{
		FileSystemClassLoader loader = new FileSystemClassLoader("/Users/Gz/Desktop/eclipse/yanjiu/bin");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("/Users/Gz/Desktop/eclipse/yanjiu/bin");

		Class<?> c = loader.findClass("classl.Hi");
		Class<?> c2 = loader.loadClass("classl.Hi");
		Class<?> c3 = loader2.loadClass("classl.Hi");
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader2.loadClass("test.Demo01");
		
		
		
		
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c3.getClassLoader());//自定义加载器
		System.out.println(c4.getClassLoader());//引导类加载器
		System.out.println(c5.getClassLoader());//app加载器
		
		
	
	
	
	
	
	
	
	}
	
	
}
