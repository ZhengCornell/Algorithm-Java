package test;

public class DeepUnderstandClassLoader {

	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		System.out.println(System.getProperty("java.class.path"));
		
		
		String a = "gaogao";
		System.out.println(a.getClass().getClassLoader());//传给BCL了
		System.out.println(a);
	
	}

}
