
public class LinearProbingHashST<Key, Value> {
	private int M = 30001;
	private Value[] vals = (Value[]) new Object[M];
	private Key[] keys = (Key[]) new Object[M];
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff) % M;
	}
	public void put(Key key, Value value){
		int i;
		for(i = hash(key); keys[i] != null; i = (i + 1) % M){//防止超出M，设定M>全部值
			if(keys[i].equals(key)) break;
			keys[i] = key;
			vals[i] = value;
		}
	}
	public Value get(Key key){
		for(int i = hash(key); keys[i] != null; i = (i + 1) % M){
			if(keys[i].equals(key)){
				return vals[i];
			}
		}
		return null;
	}
}
