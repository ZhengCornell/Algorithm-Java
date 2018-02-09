package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestEquals {
	public static void main(String args[]){
		//equals true = 重复
		List l = new ArrayList();
		String s1 = new String("aaa");
		String s2 = new String("aaa");
		String s3 = "aaa";
		l.add(s1);
		l.add(s2);
		System.out.println(s2.equals(s3));
		System.out.println(l.size());
		
		Map m = new HashMap();
		//键不能重复，equals true 覆盖
		m.put(s1,"AAAA");
		m.put(s2,"BBBB");
		System.out.println(m.get(s1));
//		
//		Set s = new HashSet();
//		s.put(s1);
//		s.put(s2);
		
	}
}
