package collection;

public class MapMonitor02 {
	//若这里无穷大，找东西用哈希码
	int size;
	LinkedList1[] em = new LinkedList1[999];//数组中放链表
	public void put(Object key, Object value){
		EntryMonitor e = new EntryMonitor(key,value);
		int hash = key.hashCode();
		hash = hash < 0 ? -hash : hash; 
		int a = hash%em.length;
		
		if(em[a] == null){
			//建造链表
			LinkedList1 l = new LinkedList1();
			//装入
			em[a] = l;
			l.add(e);
		}else{
			LinkedList1	 l = em[a];
			for(int i = 0; i< l.size(); i++){
				EntryMonitor e2 = (EntryMonitor)l.get(i);//get 的 是 键值对
				if(e2.key.equals(key)){
					e2.value = value;
					return;
				}
			}
			em[a].add(e);
		}
		//a:1000-->1;b:10000-->10;
//		em[a] = e; 不能直接丢了
		//System.out.println(key.hashCode());//根据key对象地址生成哈希码
		//em[key.hashCode()],需要将哈希码转成合理的数字对应size
		
	} 
	
	public Object get(Object key){
		int a = key.hashCode()%em.length;
		if(em[a] != null){//有链表，遍历它
			LinkedList1 l = em[a];
			for(int i = 0; i < l.size(); i++){
			EntryMonitor e = (EntryMonitor)l.get(i);
			if(e.key.equals(key)){
				return e.value;
			}
//			for(int i = 0; i < l.size(); i++){
//				EntryMonitor e = (EntryMonitor)l.get(i);
//				if(e.key.equals(key)){
//					return e.value;
//				}
//			}
			
		}
		}
		return null;
		
	}
	
	
	public static void main(String args[]){
		MapMonitor02 m = new MapMonitor02();
		m.put("gz","m");
		m.put("fz",new Wife("aaa"));
		m.put("gz",new Wife("nmb"));
//		m.remove("gz");
		Wife w = (Wife)m.get("gz");
		System.out.println(w.name);
	}
}
