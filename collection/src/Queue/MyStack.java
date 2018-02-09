package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

//使用队列实现自定义堆栈
//弹栈，压栈，获取头
public class MyStack<E> {
	//容器d
	private Deque<E> d = new ArrayDeque<E>();
	//容量c
	private int c;
	public MyStack(int c) {
		super();
		this.c = c;
	}
	public MyStack(){
		
	}
	//压栈（装东西）
	public boolean push1(E e){
		if(d.size() + 1 > c){
			return false;
		}else{
		return d.offerFirst(e);
		}
	}
	public boolean push2(E e){
		if(d.size() + 1 > c){
			return false;
		}else{
		return d.offerLast(e);
		}
	}
	//弹栈(拿东西出来)
	public E pop1(){
		return d.pollFirst();
	}
	public E pop2(){
		return d.pollLast();
	}
	//获取
	public E peek1(){
		return d.peekFirst();
	}
	public E peek2(){
		return d.peekLast();
	}
	public int size(){
		return this.d.size();
	}
	
}
