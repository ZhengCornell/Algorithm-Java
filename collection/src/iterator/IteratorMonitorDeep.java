package iterator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//深入理解 一个容器可以创建多个迭代器对象，封装之前的方法成为一个类
//内部类直接放入方法中
public class IteratorMonitorDeep implements java.lang.Iterable {
	//数组
//		private String[] elem = {"a","b","c","d","e"};
		private String[] elem = new String[5];
		//大小
		private int size = 0;
		
		public int size(){
			return this.size;
		}
		public void add(String str){
			if(this.size == elem.length){//扩容
				elem = Arrays.copyOf(elem,elem.length+5);
			}
			elem[size] = str;
			size++;
			
			
		}
		
		
//		public Iterator iterator1(){
//			return new MyIter();//每次遍历前用这个方法调出一个新的迭代器
//		}
		public Iterator iterator2(){
		 class MyIter implements Iterator{
				//计数器 指针 游标
				private int coursor = -1;
					
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
					System.arraycopy(elem,coursor + 1,elem,coursor,IteratorMonitorDeep.this.size-coursor -1 );
					IteratorMonitorDeep.this.size--; //外部类的this
					coursor--;//游标回退
				}
				}
		 return new MyIter();
			
		}
		
		public Iterator iterator(){
			return new Iterator(){//创建迭代器自己接口的实现类的匿名对象
				//计数器 指针 游标
				private int coursor = -1;
					
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
					System.arraycopy(elem,coursor + 1,elem,coursor,IteratorMonitorDeep.this.size-coursor -1 );
					IteratorMonitorDeep.this.size--; //外部类的this
					coursor--;//游标回退
				}
			};
		}
		public static void main(String args[]){
		IteratorMonitorDeep i = new IteratorMonitorDeep();
		//不必创建新的容器，只需要创造一个新的迭代器对象
		i.add("a");
		i.add("a");
		i.add("a");
		i.add("a");
		i.add("a");
		i.add("a");
		i.add("a");
		Iterator it = i.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
//			it.remove();
//			System.out.println(it.size());
		}
		System.out.println(i.size());
//		System.out.println(elem.length);
		
////		Iterator it2 = i.iterator2();
//		it = i.iterator3();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		for(Object str:i){//需要实现一个接口
			System.out.println(str);
		}
		ArrayList l = new ArrayList();
		l.add("b");
		l.add("b");
		l.add("b");
		l.add("b");
		for(Object obj:l){//增强for循环
			System.out.println(obj);
		}
		
		
		}
}
