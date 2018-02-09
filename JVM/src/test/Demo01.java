package test;
//类名，方法名，属性名，类型名，符号引用，数字 全都是常量。
public class Demo01 {
//	static{
//		System.out.println("我是king");
//	}
	public static void main(String[] args) throws ClassNotFoundException {
//		System.out.println("我是第一吗？");
//		A a = new A();
//		System.out.println(A.width);
//		A a2 = new A(); 主动引用
//		System.out.println(A.width ); 主动引用
//		System.out.println(A.MAX); 被动引用
//		Class.forName("test.A");主动
		
//		A[] array = new A[10];被动
//		System.out.println(B.width); 通过子类B引用父类A的一个静态变量width，B未初始化
	}

}
class B extends A{
	static{
		System.out.println("静态初始化B");
	}
}

class A extends A_Father{
//	public static int width=100;
	public static final int MAX=100;
	static{
		System.out.println("静态初始化类A");
		width=300;
	}
	public static int width=100;
	public A(){
		System.out.println("通过构造器产生A");
	}
}

class A_Father extends Object{
	static{
		System.out.println("爸爸先出来");
	}
	
	public A_Father(){
		System.out.println("通过构造器产生爸爸");
	}
}