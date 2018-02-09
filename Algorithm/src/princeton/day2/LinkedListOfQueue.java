package princeton.day2;

public class LinkedListOfQueue<Item> {
	private Node first = null;
	private Node last = null;
	class Node{
		Item item;
		Node next;
	}
	public void enqueue(Item item){
		if(first == null){
			first.item = item;
			last = first;
			last.next = null;
		} else {
			Node oldlast = last;
			Node last = new Node();
			last.item = item;
			last.next = null;
			oldlast.next = last;
		}
		
	}
	public Item dequeue(){
		if(first == null){
			return (Item) "";
		}else{
			Item str = first.item;
			first = first.next;
			return str;
		}
		
	}
	
	
	
}
