package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {
	private Object[] e;//底层是数组对象，叫元素对象
	private int size;
	public ArrayList1(){
		this(10);
	}
	public ArrayList1(int i){
		if(i < 0){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
		e = new Object[i];
		}
	}	
	public void add(Object o){
		//数组扩容,表象扩容，实际创造新数组,数据拷贝
		if(size == e.length){
			Object[] newArray = new Object[size*2];
//			System.arraycopy(e,0,newArray,0,e.length);
			for(int i = 0; i < e.length; i++){
				newArray[i] = e[i];
			}
			e = newArray;
		}
		
		
		e[size] = o;
		size++;
	}
	public void remove(Object o){
		for(int i = 0; i <= e.length-1; i++){
			if(e[i] == o && i != e.length -1 ){
				Object[] n = new Object[size];
				for(int j = 0; j < i; j++){
					n[j] = e[j];
				}
				for(int k = i; k < e.length - 1;k++){
						n[k] = e[k+1];
						
					
				}
//				n[size] = null;
				e = n;
				
			}else if(e[i] == o && i == e.length - 1){
				Object[] n = new Object[size];
				for(int j = 0; j < i; j++){
					n[j] = e[j];
//				} n[i] = null;
				e = n;
				
			}
		}
		
		
		
	}
	}

	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	public Object get(int index){
		if(index < 0 || index >= size)
			try {
				throw new Exception();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		return e[index];
	}

	public static void main(String args[]){
		ArrayList1 l = new ArrayList1(3);
		l.add("1");
		l.add("2");
		l.add("3");
		l.add("4");
		l.add("5");
		l.add("6");
		System.out.println(l.size());
		System.out.println(l.isEmpty());
		l.remove("4");
		System.out.println(l.get(5));
		
	}
	
}
