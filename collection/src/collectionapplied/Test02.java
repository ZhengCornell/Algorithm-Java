package collectionapplied;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
	public static void main(String args[]){//也产生了三个对象
		//一个Map对应一行纪录，没有写表结构类，key相当于字段名
		Map m = new HashMap();
		m.put("id",0301);//弄成字符串 更好
		m.put("name", "gz");
		m.put("salary",3000);
		m.put("department","Cornell");
		m.put("hireDate","2007-10");
		
		Map m2 = new HashMap();
		m2.put("id",0301);
		m2.put("name", "gz");
		m2.put("salary",3000);
		m2.put("department","Cornell");
		m2.put("hireDate","2007-10");
		
		Map m3 = new HashMap();
		m3.put("id",0301);
		m3.put("name", "gz");
		m3.put("salary",3000);
		m3.put("department","Cornell");
		m3.put("hireDate","2007-10");

		List<Map> l = new ArrayList<Map>();
		
		l.add(m);
		l.add(m2);
		l.add(m3);
		
		printName(l);
	}
	public static void printName(List<Map> l){
		for(int i = 0; i < l.size(); i++){
			Map t = l.get(i);
			System.out.println(t.get("name")+"-----"+t.get("salary"));
		}
	}
}
