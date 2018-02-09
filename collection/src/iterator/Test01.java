package iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test01 {
	public static void main(String args[]){
		List l = new ArrayList();
		l.add("aaa");
		l.add("bbb");
		l.add("ccc");
		l.add("ddd");
//		for(int i = 0; i < l.size(); i++){
//			System.out.println(l.get(i));
//		}
		for(Iterator i2 = l.iterator()/*获得迭代器*/; i2.hasNext()/*是否有下一个*/;){//接口定义了hasNext() next() remove()
			String str = (String) i2.next();
			System.out.println(str);
			i2.remove();
	
		}
		System.out.println(l.size());
		
		Set s = new HashSet();
		s.add("高1");
//		s.add("高2");
//		s.add("高3");
//		s.add("高4");
		
//		Iterator i = s.iterator();
//		while(i.hasNext()){ 
//			String str = (String) i.next();
//			System.out.println(str);
//		}
/*OR*/	for(Iterator i = s.iterator()/*获得迭代器*/; i.hasNext()/*是否有下一个*/;){//接口定义了hasNext() next() remove()
			String str = (String) i.next();
			System.out.println(str);
	
		}
	}
	
}
