//结合linkedlist 和 array
public class HashTable<Key,Value> {
	private int M = 97;
	private Node[] st = new Node[M];
	private static class Node{
		private Object key;
		private Object value;
		private Node next;
		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
	}
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff) % M;
	}
	public Value get(Key key){
		int i = hash(key);//相同hash 的很多，都装在这个数组中，然后链表形式连接
		for(Node x = st[i]; x != null; x = x.next){
			if(key.equals(x.key)) return (Value) x.value;
		}
		return null;
	}
	public void put(Key key, Value value){
		int i = hash(key);
		for(Node x = st[i]; x != null; x = x.next){
			if(key.equals(x.key)) {
				x.value = value;
				return;
			}
			st[i] = new Node(key, value,st[i]);//创建在第一个
		}
	}
	
}
