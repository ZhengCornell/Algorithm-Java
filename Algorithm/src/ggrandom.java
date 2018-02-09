import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class ggrandom<Item> implements Iterable<Item> {
	private Item[] i = (Item[]) new Object[0];
	private int numElems = 0;
	public ggrandom(){
	}
	public boolean isEmpty(){
		return numElems == 0;
	}
	public int size(){
		if(isEmpty()) return 0;
		int count = 0;
		for(Item temp:i){
			count++;
		}
		return count;
	}
	public void enqueue(Item item){
		if(item == null){
			throw new IllegalArgumentException();
		}
		final int size = i.length;
		if(size == 0){
			resize(1);
		}else if(size <= numElems){
			resize(2*size);
		}
		i[numElems++] = item;
	}
	public Item dequeue(){
		if(isEmpty()){
			throw new IllegalArgumentException();
		}
		int rand = StdRandom.uniform(numElems);
		Item obj = i[rand];
		i[rand] = i[--numElems];
		if(numElems > 0 && numElems == this.i.length / 4){
			resize(this.i.length/2);
		}
		return obj;
	}
	public Item sample(){
		if(isEmpty()){
			throw new IllegalArgumentException();
		}
		Item obj = null;
		while(obj == null){
		int rand = StdRandom.uniform(numElems);
		obj = i[rand];
		}
		return obj;
	}
	
	public Iterator<Item> iterator(){
		return new RIterator<Item>(i);
	}
	private static class RIterator<Item> implements Iterator<Item>{
		private ggrandom<Item> newColl = new ggrandom<Item>();
		
		public RIterator(Object[] is){
			for(Object temp:is){
				if(temp == null) {break;}
				newColl.enqueue((Item) temp);
			}
		}

		public boolean hasNext() {
			return !newColl.isEmpty();
		}

		public Item next() {
			if(newColl.isEmpty()){
				throw new UnsupportedOperationException();
			}
			return newColl.dequeue();
			
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}
	
	private void resize(int n){
		Item[] temp = (Item[]) new Object[n];
		final int arrLength = i.length;
		int k = 0;
		if(arrLength > n){
			k = n;
		}else{
			k = arrLength;
		}
		System.arraycopy(i,0,temp,0,k);
		i = temp;
	}
}
