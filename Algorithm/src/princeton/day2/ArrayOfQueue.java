package princeton.day2;

import java.util.Iterator;

public class ArrayOfQueue<Item> implements Iterable<Item> {
	private Item[] q;
	private int head = 0;
	private int tail = 0;
	
	public ArrayOfQueue(){
		q = (Item[])new Object[1];
	}
	public void enqueue(Item item){
		if(tail == q.length){
			resize1(2*q.length);
		}
		q[tail] = item;
		tail = tail + 1;
	}
	public Item dequeue(){
		Item str = q[head];
		if(q[head] == null){
			return null;
		}
		head = head + 1;
		if(head >= 0 && tail >= 0 && 3*tail <= 4*head){
			resize2(q.length/2);
		}
		return str;
	}
	public void resize1(int size){

		Item[] copy =  (Item[])new Object[size];;
		for(int i = 0; i < tail; i++){
			copy[i] = q[i];
		}
		q = copy;
	}

	public void resize2(int size){
		Item[] copy =  (Item[])new Object[size];;
		for(int i = head; i < tail ;i++){
			copy[i-head] = q[i];
		}
		this.head = 0;
		this.tail = tail - head;
		q = copy;	
	}
	public Iterator<Item> iterator(){
		return new Qiterator();
	}
	private class Qiterator<Item> implements Iterator<Item>{
		private int i = tail;
		public boolean hasNext(){
			return i > 0;
		}
		public Item next(){
			return (Item) q[--i];//从尾巴进
		}
		
	}
}
