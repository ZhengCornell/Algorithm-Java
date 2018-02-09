
public class PriQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;
	public PriQ(int capacity){
		pq = (Key[]) new Object[capacity];
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public void insert(Key key){
		pq[N++] = key;
	}
	public Key delMax(){
		int max = 0;
		for(int i = 0; i < N; i++){
			if(max < i){
				max = i;
			}
		}
		exch(max,N-1);
	
		return pq[--N];
	}
	private void exch(int a, int b){
		int c = a;
		a = b;
		b = c;
	}
	
}
