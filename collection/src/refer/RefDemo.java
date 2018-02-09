package refer;

import java.lang.ref.WeakReference;

public class RefDemo {
	public static void main(String args[]){
		//放在字符串常量池，共享（不能回收）
//		String str = "i am your dad";
		String str = new String("i am your dad");
		//弱引用管理对象(常量池共享不能回收，不共享的可以回收)
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println(wr.get());
		//断开引用
		str = null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println(wr.get());
	}
	
	
}
