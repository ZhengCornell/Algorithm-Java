package collection;

import java.util.HashMap;
import java.util.Map;

//测试map基本用法
public class TestMap {
	public static void main(String args[]){
		Map m = new HashMap();
		m.put("gz",new Wife("slr"));
		m.put("fx",new Wife("ym"));
		
//		m.remove("gz");
		
		Wife w = (Wife)m.get("gz");//Object 类型，需要强制转型
		m.remove("gz");
		m.containsKey("zs");
		System.out.println(w.name);
//		m.remove("gz");
	}
	
}

class Wife{
	String name;
	public Wife(String name){
		this.name = name;
	}
}
