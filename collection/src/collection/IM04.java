package collection;

import java.util.Arrays;
import java.util.Iterator;

public class IM04<E> implements java.lang.Iterable<E> {
	private Object[] elem = new Object[3];
	private int size = 0;
	private int coursor = -1;
	public int size(){
		return this.size = size;
	}
	public <E>void add(E e){
		if(this.size == elem.length){
			elem = Arrays.copyOf(elem,elem.length+5);
		}
		elem[size] = e;
		this.size++;
	}
	public Iterator<E> iterator(){
		return new Iterator<E>(){//一个迭代器对象
			private int coursor = -1; 
			public boolean hasNext(){
				return coursor + 1 < size;
			}
			public E next(){
				if(hasNext()){
					coursor = coursor + 1;
					return (E)elem[coursor];
				}else{
					return null;
				}
			}
			public void remove(){
				System.arraycopy(elem,coursor+1,elem,coursor,IM04.this.size - coursor - 1);
				IM04.this.size--;
				coursor--;
			}
		};
	}
	
	
	
	
	
	
	
	
	public static void main(String args[]){
		IM04<Object> i = new IM04<Object>();
		IM04<String> i2 = new IM04<String>();
		IM04<Integer> i3 = new IM04<Integer>();
		Iterator<Object> it =i.iterator();
		Iterator<String> it2 =i2.iterator();
		Iterator<Integer> it3 =i3.iterator();
		i.add("i");
		i.add("j");
		i.add("k");
		i.add("l");
		i2.add("m");
		i2.add("n");
		i3.add(2);
		i3.add(4);
		i3.add(6);
		
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		for(Object str:i){//容易看出，i对象是Object类型
			System.out.println(str);
		}
		while(it2.hasNext()){
			String s = it2.next();
			System.out.println(s);
		}
//		for(String str:i2){
//			System.out.println(str);
//		}
		for(Integer str:i3){
			System.out.println(str);
		}
	}
}
