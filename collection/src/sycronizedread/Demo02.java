package sycronizedread;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//只读设置
//empty+++LMS
//空的不可变集合，防止空指针异常
//只可变一个元素 singleton+++
//完全不可变容器 unmodifiable+++
public class Demo02 {
	public static void main(String args[]){
		Map<String,String> m = new HashMap<String,String>();
		m.put("a","a");
		m.put("b","b");
		//只读控制
		Map<String,String> k = Collections.unmodifiableMap(m);
		k.put("c","c");
		System.out.println(k);
		//一个元素容器测试
		String str = new String();
		List<String> l = Collections.singletonList(str);
//		List<String> l = Collections.singletonList(new String());
		l.add("a");
		l.add("b");
		
			
		
	}
	public static Set<String> oper(Set<String> s){
		if(null == s){
			return Collections.EMPTY_SET;	//外部获取避免无指针
		}
		return s;
	}
}
