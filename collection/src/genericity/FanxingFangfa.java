package genericity;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//泛型方法
public class FanxingFangfa {
//	public static void main(String args[]){
//		test("gg");//M 就自动变成 String 
//		test(123);//M 就自动变成了 Integer
//	}
	public static <M extends List> void test(M a){
//		这个a也不能在方法中被使用。除非extends
		System.out.println(a);
		a.add("aaa");
	}
	public static <M> void test(M a){
//		这个a也不能在方法中被使用。除非extends
		System.out.println(a);
	}
	public static <M extends Closeable> void test(M... a){
//		这个a也不能在方法中被使用。M 是接口Closeable 的实现类，直接调用接口里的方法
		for(M temp:a){//
			try {
				temp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		FanxingFangfa f = new FanxingFangfa();
		
		test("gg");//M 就自动变成 String 
		test(123);//M 就自动变成了 Integer
		test(new FileInputStream("a.txt"));
		
}
}
