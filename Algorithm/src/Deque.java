import java.util.NoSuchElementException;

import java.util.Iterator;
    
public class Deque<Item> implements Iterable<Item> {
    
    private Node first, last;
    private int N;
    private class Node {
        Item item;
        Node next;
        Node previous;
    }
    
    public Deque() {                           // construct an empty deque
        first = null;
        last = null;
        N = 0;
    }
   
   public boolean isEmpty() {                 // is the deque empty?
       return N == 0;
   }
   
   public int size(){                        // return the number of items on the deque
       return N;
   }
   public void addFirst(Item item) {          // add the item to the front
       if (item == null) throw new NullPointerException();
       Node oldfirst = first;
       first = new Node();
       first.item = item;
       first.next = oldfirst;
       first.previous = null;
       if (isEmpty()) {
           last = first;
           first.next = null;
       }
       else if (oldfirst != null) {
           oldfirst.previous = first;
       }
       N++;
       if(N == 1){
    	   last = first;
       }
      
   }
   public void addLast(Item item) {          // add the item to the end
	   if (item == null) throw new NullPointerException();
       Node oldlast = last;
       last = new Node();
       last.item = item;
       last.next = null;
       last.previous = oldlast;
       if (isEmpty()) {
           first = last;
           last.previous = null;
       }
       else if (oldlast != null) {
           oldlast.next = last;
       }
       N++;
       if(N == 1){
    	   first = last;
       }
   }
   public Item removeFirst() {                // remove and return the item from the front
       if(isEmpty()) { throw new NoSuchElementException(); }
       Item item = first.item;
       first = first.next;
       if(first != null){
       first.previous = null;
       }
       if(isEmpty()){
    	   last = null;
    	   first = null;
       }
       N--;
       return item;
   }
   public Item removeLast() {                 // remove and return the item from the end
       if(isEmpty()) throw new NoSuchElementException();
       Item item = last.item;
       last = last.previous;
       if(last != null){
       last.next = null;
       }
       if(isEmpty()){
    	   last = null;
    	   first = null;
       }
       N--;
       return item;
   }
   
   public Iterator<Item> iterator() {        // return an iterator over items in order from front to end
       return new ListIterator();
   }
   
   private class ListIterator implements Iterator<Item> {
       
       private Node current = first;
       public boolean hasNext() { return current != null; }
       public void remove() { throw new UnsupportedOperationException();  }

       public Item next() {
           if (!hasNext()) throw new NoSuchElementException();
           Item item = current.item;
           current = current.next;
           return item;
       }
           
   }
   public static void main(String[] args){   // unit testing
     Deque<Integer> deck = new Deque<Integer>();
     deck.addFirst(1);
     deck.addFirst(2);
     deck.addFirst(3);
     deck.addFirst(4);
     for(int i : deck){
    	 System.out.println(i);
     }
 }
   
}