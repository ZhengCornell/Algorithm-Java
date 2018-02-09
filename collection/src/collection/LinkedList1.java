package collection;

public class LinkedList1 {
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object obj){//此方法是从最后加
			Node n = new Node();
		if(first == null){//如果不存在第一个节点，就创造一个第一个节点
//			Node n = new Node();//创建新节点
			n.setPrevious(null);
			n.setObj(obj);//节点中装对象
			n.setNext(null);
			first = n;
			last = n; // 无中生有时候第一个就是第一也是最后

		}else{//往last节点后新增加节点
//			Node n = new Node();
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			
			last.setNext(n);//双向链表建立连接 
			
			last = n;//交接棒	
		}
		size++;
	}
	public int size(){
		return size;
	}
	
	public void rangeCheck(int index){
		if(index < 0 || index >= size/*size相当于length*/){
			try{
				throw new Exception();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	public Node search(int index){//遍历
		//index 和size／2 比较
		Node temp = null;
		
		if(first == null){
		
		}else{
			if(index < (size >> 1)){
			temp = first;
			
//		while(temp.next != null){
//			temp = temp.next;
//		}
			for(int i = 0; i <= index - 1; i++){
			temp = temp.next;
			}
			}else{
			temp = last;
			
			for(int i = size - 1; i > index;i--){
			temp = temp.previous;
			}
			}
		}
		
		
		return temp;
	}
	
	public Node search(Object obj){
		Node temp = null;
		if(first == null){
			
		}else{
			temp = first;
			for(int i = 0; i < size;i++){
				while(temp.obj != obj){
					temp = temp.next;
				}
				break;
			}
		}
		return temp;
	}
	
	public Object get(Object obj){
		Node temp = search(obj);
		if(temp != null){
			return temp.obj;
		}else{
			return null;
		}
	}
	
	public Object get(int index){
		//a b c d e 
		rangeCheck(index);
//		Node temp = null;
//		if(first == null){
//			
//		}else{
//			temp = first;
////			while(temp.next != null){
////				temp = temp.next;
////			}
//			for(int i = 0; i <= index - 1; i++){
//				temp = temp.next;
//			}
//		}
		//越界处理，index 越界怎么办？保证在0和size之间
//			Node temp = new Node();
//			temp.search(index); 不可以这么写， 因为search 不是temp对象的方法
			Node temp = search(index);
			if(temp != null){
				return temp.obj;
			}else{
				return null;
			}
		
			
	}
	
	public void remove(int index){
//		Node temp = null;
//			if(first == null){
//			
//			}else{
//				temp = first;
////			while(temp.next != null){
////				temp = temp.next;
////			}
//				for(int i = 0; i <= index - 1; i++){
//				temp = temp.next;
//				}
//			}
		
		Node temp = search(index);
			if(temp != null){
				Node shang = temp.previous;//获取上一个节点
				Node xia = temp.next;//获取下一个姐节点
				shang.setNext(xia);
				xia.setPrevious(shang);
				size --;
			}
		
	}
	public void replace(int index, Object obj){
		Node n = new Node();
		n.setPrevious(null);
		n.setNext(null);
		n.setObj(obj);
		Node temp = search(index);
		if(temp != null){
		Node shang = temp.previous;
		Node xia = temp.next;
		
		shang.setNext(n);
		xia.setPrevious(n);
		}
	}
	public void insert(int index, Object obj){
		Node n = new Node();
		n.setPrevious(null);
		n.setNext(null);
		n.setObj(obj);
		Node temp = search(index);
		if(temp != null){
		Node shang = temp.previous;
//		Node xia = temp.next;
		shang.setNext(n);
		n.setNext(temp);
		size ++;
		}
	}
	public void clear(){

		for(Node x = first; x != null;){
			Node next = x.next;
			x.obj = null;
			x.previous = null;
			x.next = null;
		}
	}
		
	
	

	
	public static void main(String args[]){
		LinkedList1 l = new LinkedList1();
		l.add("一");
		l.add("二");
		l.add("三");
		l.add("四");
		l.add("五");
		l.add("六");
//		l.clear();
//		l.insert(2,"插入！");
//		l.replace(2,"取代！");
//		l.remove(1);
		System.out.println(l.size());
		System.out.println(l.get(5));
////		System.out.println();
//		System.out.println(l.get("四"));
	}
	
}
