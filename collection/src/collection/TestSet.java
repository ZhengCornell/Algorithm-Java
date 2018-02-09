package collection;

import java.util.HashSet;
import java.util.Set;

public class TestSet {
	
	
	
	
	
	public static void main(String args[]){
		Set s = new HashSet();
		s.add("aaa");
		s.add("bbb");
		s.add(new String("bbb"));
		System.out.println(s.size());
		System.out.println(s.contains("aaa"));
	}

}
