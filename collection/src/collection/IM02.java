package collection;
//运用普通内部类，创建多个迭代器对象
import java.util.Arrays;
import java.util.Iterator;

public class IM02 {
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
	public Iterator i2(){
		class MyIter implements Iterator{//所有属性中只需要重新定义coursor
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
				System.arraycopy(elem,coursor+1,elem,coursor,IM02.this.size - coursor - 1);
				IM02.this.size--;
				coursor--;
			}
		}
		return new MyIter();
	}
	

	public static void main(String args[]){
		IM02 i = new IM02();
		Iterator it =i.i2();
		i.add("e");
		i.add("f");
		i.add("g");
		i.add("h");
		it.hasNext();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
