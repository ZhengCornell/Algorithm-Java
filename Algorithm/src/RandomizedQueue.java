import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
   private int head = 0;
   private int tail = 0;
   private Item[] array;
    
   public RandomizedQueue() {                 // construct an empty randomized queue
        array = (Item[]) new Object[1];    
    }
   public boolean isEmpty() {                 // is the queue empty?
       return size() == 0;
   }
   
   public int size() {                        // return the number of items on the queue
       return tail-head;
   }
   private void resize(int capacity) {
       Item[] copy = (Item[]) new Object[capacity];
       int tmpTail = 0;
       for (int i = 0; i < capacity; i++) {
    	   if(i < size()){
    		   copy [i] = array[i+head];
    		   tmpTail = i + 1;
    	   } else {
    		   copy[i] = null;
    	   }
    	  
       }
       head = 0;
       tail = tmpTail;
       array = copy;
   }
   
   public void enqueue(Item item) {          // add the item
       if (item == null) throw new NullPointerException();
       
       if (tail == array.length) resize(2*array.length);
       array[tail++] = item; 
   }
   public Item dequeue() {                   // remove and return a random item
      if (isEmpty()) throw new NullPointerException();
      
      Item item = array[head];
      array[head] = null;
      head++;
      
      if (size() > 0 && size() == array.length/4) resize(array.length/2);
      return item;
   }
   public Item sample() {                    // return (but do not remove) a random item
      if (isEmpty()) throw new NullPointerException();
      int random = StdRandom.uniform(head,tail);
      return array[random];
   }
   
   public Iterator<Item> iterator() {        // return an independent iterator over items in random order
       return new RandomIterator();
   }
   
   private class RandomIterator implements Iterator<Item> {
	   private int[] usedIndexes = new int[size()];
	    private int usedIndexesCount = 0;

	    public RandomIterator() {
	      for (int i = 0; i < usedIndexes.length; i++) {
	        usedIndexes[i] = 0;
	      }
	    }

	    public boolean hasNext() {
	      return usedIndexes.length != usedIndexesCount;
	    }

	    public Item next() {
	      if (!hasNext()) {
	        throw new NoSuchElementException();
	      }

	      int randomIndex = -1;
	      do {
	        randomIndex = StdRandom.uniform(head, tail);
	      } while (randomIndex == -1 || usedIndexes[randomIndex - head] == 1);

	      usedIndexes[randomIndex - head] = 1;
	      usedIndexesCount++;

	      return array[randomIndex];
	    }

	    public void remove() {
	      throw new UnsupportedOperationException();
	    }

           
   }
   public static void main(String[] args) {  
	    RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();

	    rq.enqueue(1);
	    rq.enqueue(2);
	    rq.enqueue(3);
	    rq.enqueue(4);
	    rq.enqueue(5);
	    rq.enqueue(6);

	    for (int i : rq) {
	      System.out.println(i);
	    }
	}
}
