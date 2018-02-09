package collection;

import java.util.HashMap;

public class SetMonitor {
	HashMap map;
	private static final Object PRESENT = new Object();
	public  SetMonitor(){
		map = new HashMap();
	}
	public int size(){
		return map.size();
	}
	public void add(Object key){
		map.put(key,PRESENT);//实现了不可重复，利用了Map中Key不可重复
	}
	public void remove(Object key){
		map.remove(key);
	}
	
	
	public static void main(String args[]){
		SetMonitor s = new SetMonitor();
		s.add(new String("aaa"));
		s.add(new String("bbb"));
		s.add(new String("ccc"));
		s.add(new String("ddd"));
		s.remove("ddd");
		System.out.println(s.size());
	}
}
