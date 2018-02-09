package princeton.day2;

import edu.princeton.cs.algs4.StdRandom;

public class Shuffle {
	public static void shuffle(int[] a){
		int n = a.length;
		
		for(int i = 0; i < n; i++){
			int r = StdRandom.uniform(i+1);
			exch(a,r,i);
		}
		
		
		
	}
	
	
	
	
	
	public static void exch(int[] a, int i, int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
}
