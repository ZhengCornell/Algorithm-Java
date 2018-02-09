package atraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stats {

	public static void main(String[] args) throws IOException {
	FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while(true){
	String str = br.readLine();
	
		if(!str.equals("-")) s.push(str);
		else if(!s.isEmpty()) System.out.println("推出"+s.pop());
	
	}}

}

class FixedCapacityStackOfStrings{
	private String[] a;
	private int N;
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void push(String item){
		a[N++] = item;
	}
	public String pop(){
		return a[N--];
	}
	
	
	
}