package refer;

import java.util.IdentityHashMap;

//键比较地址去重
//前两个中a在常量池，是同一个地址
//后两者因为都是属于各自对象的地址，彼此不同
public class IdentityHashMapDemo {

	public static void main(String[] args) {
		IdentityHashMap<String,String> m = new IdentityHashMap<String,String>();
		//a在常量池中，存在就获取
		m.put("a","a1");
		m.put("a","a2");
		m.put(new String("a"),"a3");
		m.put(new String("a"),"a4");
	}

}
