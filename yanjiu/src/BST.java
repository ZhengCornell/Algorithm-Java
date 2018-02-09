import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Node left;
		private Node right;
		private Key key;
		private Value value;
		private int count;
		public Node( Key key, Value value) {
		
		
			this.key = key;
			this.value = value;
		}
		
		
	}
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if (x == null) return 0;
		return x.count;
	}
	public void put(Key key, Value value){
		root = put(root,key,value);
	}
	private Node put(Node x, Key key, Value value){
		if(x == null) return new Node(key,value);
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			x.left = put(x.left,key,value);
		}
		if(cmp>0){
			x.right = put(x.right,key,value);
		}
		else{
			x.value = value;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public Value get(Key key){
		Node x = root;
		while(x != null){
			int cmp = key.compareTo(x.key);
			if(cmp < 0) x = x.left;
			else if(cmp > 0) x = x.right;
			else return x.value;
		}
		return null;
	}

	public void delete(Key key){
		root = delete(root,key);
	}
	private Node min(Node x){
		while(x.left != null){
		x = x.left;
		}
		return x;
	}
	public void deleteMin(){
		root = deleteMin(root);//操作整个树要从操作根开始
	}
	private Node deleteMin(Node x){
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	private Node delete(Node x, Key key){
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left,key);
		else if(cmp > 0) x.right = delete(x.right,key);
		else{
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	
	public Key floor(Key key){
		Node x = floor(root,key);
		if(x == null) return null;
		return x.key;
	}
	private Node floor(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0) {
			return x;
		}
		if(cmp < 0) {
			return floor(x.left,key);
		}
		else{
			Node t = floor(x.right,key);
			if(t != null) return t;
			else return x;
		}
	
	
	
	}
	public int rank(Key key){
		return rank(key,root);
	}
	private int rank(Key key, Node x){
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(key, x.left);
		if(cmp > 0) return rank(key,x.right) + 1 + size(x.left);
		else return size(x.left);
	}
	
	public Iterable<Key> iterator(){
		Queue<Key> q = new Queue<Key>();
		inorder(root ,q);
		return q;
	}
	private void inorder(Node x, Queue<Key> q){//中序遍历把东西都装进了q中
		if(x == null) return;
		inorder(x.left,q);
		q.enqueue(x.key);
		inorder(x.right,q);
	}

}
