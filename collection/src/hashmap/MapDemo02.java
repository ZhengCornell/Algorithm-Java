package hashmap;
//加入面向对象
import java.util.HashMap;
import java.util.Map;

public class MapDemo02 {
	public static void main(String args[]){
		String[] s = "this is a cat and that is a mice and where is the food".split(" ");
		//分拣各地包裹，从北京天津上海到s末尾。
		Map<String,Javabean1> m = new HashMap<String,Javabean1>();
		for(String key:s){
			if(!m.containsKey(key)){//造篮子 并命名
//				这里可以选择直接new，因为根本没引用对象
//				Javabean1 j = new Javabean1(key);
				m.put(key,new Javabean1());
			}//东西是count，把东西放篮子里，
			 //是个循环，下次的value 和key都是全新的
			Javabean1 value = m.get(key);
			value.setCount(value.getCount()+1);
	
		}
//		取货
//		for(String key:s){
//			Javabean1 value = m.get(key);//先尝试取篮子
//			if(value == null){//没篮子则造篮子,
////			value 此时有个空地址了，不能重造value，只能重写地址
////			这也是为什么不能直接在put里new 的原因
//				value = new Javabean1();
//				m.put(key,value);
//			}
//			value.setCount(value.getCount()+1);
//			
//		}
		
		for(String key:m.keySet()){//从当前key到跑完
			Javabean1 value = m.get(key);
			System.out.println(key + value.getCount());
		}
		
		
		
	}
}
