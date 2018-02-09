package collection;
//存放键值对,根据键找值
//此方法效率较低，每次搞都要跑一圈
public class MapMonitor {
	EntryMonitor[] em = new EntryMonitor[9990];//数组中放键值队
	int size;
	public void put(Object key, Object value){
		
		EntryMonitor e = new EntryMonitor(key, value);
		for(int i = 0; i < size; i++){
			if(em[i].key.equals(key)){
				em[i].value = value;
				return;
			}
				
		}
	em[size++] = e;
		
	}
	
	public Object get(Object key){//效率很低
		for(int i = 0; i < size; i++){
			if(em[i].key.equals(key)){
				return em[i].value;
			}
		}
		return null;
	}
	public void remove(Object key){
		for(int i = 0; i < size; i++){
			if(em[i].key.equals(key)){
				em[i] = null;
//				EntryMonitor[] k = new EntryMonitor[9990];
//				for(int j = 0; j < i; j++){
//					k[j] = em[j];
//				}
//				for(int d = i; d < size - 1; d++){
//					k[d] = em[d + 1];
//				}
			}
		}
		
	}
	
	public boolean containsKey(Object key){
		for(int i = 0; i < size; i++){
			if(em[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		MapMonitor m = new MapMonitor();
		m.put("gz","1");
		m.put("fz",new Wife("aaa"));
		m.put("gz",new Wife("nmb"));
//		m.remove("gz");
		Wife w = (Wife)m.get("gz");
		System.out.println(w.name);
		
	}
}

class EntryMonitor{
	Object key;
	Object value;
	public EntryMonitor(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}