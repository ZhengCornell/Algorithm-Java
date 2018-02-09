package TreeSetTreeMap;

import java.util.TreeSet;

public class TestSetDemo02 {
	public static void main(String args[]){
		Worker w1 = new Worker("aaa",100);
		Worker w2 = new Worker("bbb",200);
		Worker w3 = new Worker("ccc",300);
		Worker w4 = new Worker("ddd",400);
		//转变为接口
		TreeSet<Worker> t = new TreeSet<Worker>();//
		t.add(w1);
	}
}
