package refer;

import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		WeakHashMap<String,String> m = new WeakHashMap<String,String>();
		//测试数据
		m.put("abc","a");
		m.put("d","test");
		m.put(new String("bjsxt"),"c");
		m.put(new String("dsf"),"d");
		System.gc();
		System.runFinalization();
		//前两个常量池对象不回收
		//后两个 gc运行就回收了
		
	}

}
