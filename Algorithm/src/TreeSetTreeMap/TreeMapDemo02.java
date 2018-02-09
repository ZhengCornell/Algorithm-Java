package TreeSetTreeMap;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo02 {
	public static void main(String args[]){
		Worker w1 = new Worker("aaa",100);
		Worker w2 = new Worker("bbb",200);
		Worker w3 = new Worker("ccc",300);
		Worker w4 = new Worker("ddd",400);
		
		TreeMap<Worker,Integer> e =  new TreeMap<Worker,Integer>();
		e.put(w1,1);
		e.put(w2,1);
		e.put(w3,1);
		e.put(w4,1);
		
		Set<Worker> s = e.keySet();
		System.out.println(s);
	}
}
