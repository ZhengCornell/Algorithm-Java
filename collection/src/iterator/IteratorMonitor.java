package iterator;

public class IteratorMonitor {
	//数组
	private String[] elem = {"a","b","c","d","e"};
	//大小
	private int size = elem.length;
	//计数器 指针 游标
	private int coursor = -1;
	
	public int size(){
		return this.size;
	}
	
	//判断是否有下一个
	public boolean hasNext(){
		return coursor + 1 < size;
	}
	
	//获取下一个
	public String next(){
		if(hasNext()){
		coursor++;
		return elem[coursor]; 
		}else{
		return null;
		}
	}
	
	//删除下一个
	public void remove(){
		//移动数组
		System.arraycopy(elem,coursor + 1,elem,coursor,this.size-coursor -1 );
		this.size--;
		coursor--;//游标回退
	}
	
	public static void main(String args[]){
		IteratorMonitor i = new IteratorMonitor();
		if(i.hasNext()){
			System.out.println(i.next());
			i.remove();
		}
		if(i.hasNext()){
			System.out.println(i.next());
			i.remove();
		}
		if(i.hasNext()){
			System.out.println(i.next());
			i.remove();
		}
		if(i.hasNext()){
			System.out.println(i.next());
			i.remove();
		}
		if(i.hasNext()){
			System.out.println(i.next());
			i.remove();
		}
		System.out.println(i.size());
//		i = new IteratorMonitor();
//		while(i.hasNext()){
//			System.out.println(i.next());
//			
//		}
	
	}
}
