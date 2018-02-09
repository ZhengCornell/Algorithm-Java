package collection;
//运用匿名内部类，直接返回一个有效迭代器,切记子类方法需要同名实现
import java.util.Arrays;
import java.util.Iterator;

public class IM03 implements java.lang.Iterable{
	private String[] elem = new String[3];
	private int size = 0;
	private int coursor = -1;
	public int size(){
		return this.size = size;
	}
	public void add(String str){
		if(this.size == elem.length){
			elem = Arrays.copyOf(elem,elem.length+5);
		}
		elem[size] = str;
		this.size++;
	}
	public Iterator iterator(){
		return new Iterator(){//一个迭代器对象
			private int coursor = -1;
			public boolean hasNext(){
				return coursor + 1 < size;
			}
			public String next(){
				if(hasNext()){
					coursor = coursor + 1;
					return elem[coursor];
				}else{
					return null;
				}
			}
			public void remove(){
				System.arraycopy(elem,coursor+1,elem,coursor,IM03.this.size - coursor - 1);
				IM03.this.size--;
				coursor--;
			}
		};
	}
	
	
	
	
	
	
	
	
	public static void main(String args[]){
		IM03 i = new IM03();
		Iterator it =i.iterator();
		i.add("i");
		i.add("j");
		i.add("k");
		i.add("l");
		it.hasNext();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		for(Object str:i){//容易看出，i对象是Object类型
			System.out.println(str);
		}
	}
}
