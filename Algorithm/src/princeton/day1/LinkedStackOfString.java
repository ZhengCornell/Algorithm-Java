package princeton.day1;

import java.util.Iterator;

public class LinkedStackOfString implements Iterable{
	private Node first = null;
	private class Node{
		String item;
		Node next;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void push(String item){
		Node of = first;
	 	first = new Node();
		first.item = item;
		first.next = of;
	}
	public String pop(){
		String o = first.item;
		first = first.next;
		return o;
	}
	public Iterator iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator{
		private Node temp = first;
		public boolean hasNext(){
			return temp != null;
		}
		public String next(){
			String str = temp.item;
			temp = temp.next;
			return str;
		}
	}
}
