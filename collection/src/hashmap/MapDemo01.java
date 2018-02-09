package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//统计单词出现的次数
//分拣存储1:N
//分割字符串，分拣存储，按要求查案出现次数
public class MapDemo01 {
	public static void main(String args[]){
		//分割字符串
		String[] s = "this is a cat and that is a mice and where is the food".split(" ");
		//分拣存储
		Map<String,Integer> m = new HashMap<String,Integer>();
		for(String key:s){
//			System.out.println(key);//查看单词出来没
			if(m.containsKey(key)){//查看是否存在该单词
				//存在，则覆盖原有键值对 ，value＋1；
				Integer k = m.get(key);
				m.put(key, m.get(key) + 1);
			}else{//不存在则建立键值对
				m.put(key,1);
			}
//			Integer value = m.get(key);
//			if(value == null){
//				m.put(key, 1);
//			}else{
//				m.put(key,value + 1);
//			}
		
		
		}
		//查看每个单词出现的次数
		Set<String> keySet = m.keySet();
		//获取对象
		Iterator<String> i = keySet.iterator();
		
			
		
		while(i.hasNext()){
			String key = i.next();
//			Integer value = m.get(key);
			System.out.println(key+"---"+m.get(key));
//			System.out.print(i.next());
//			System.out.println(m.get(i.next()));
//			String key = i.next();
//			Integer value = m.get(key);
//			System.out.println(i.next()+"---"+m.get(i.next()));
		}
		
		
		
	

	
	}

}
