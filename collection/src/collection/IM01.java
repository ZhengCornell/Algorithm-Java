package collection;

import java.util.Arrays;

public class IM01 {
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
		System.arraycopy(elem,coursor+1,elem,coursor,this.size - coursor - 1);
		this.size--;
		coursor--;
	}
	
	public static void main(String args[]){
		IM01 i = new IM01();
		i.add("a");
		i.add("b");
		i.add("c");
		i.add("d");
		i.hasNext();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
