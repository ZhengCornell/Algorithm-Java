package atraining;

public class Search {
	public static int count = 0;
	public static void main(String[] args) {
		int N=1000;
		int T = 100000;
		
		for(int i = 1; i <= T; i++){
		int a0 = (int)(1+Math.random()*(N));
		int a1 = (int)(1+Math.random()*(N-a0));
		int a2 = (int)(1+Math.random()*(N-a0-a1));
		int a3 = (int)(1+Math.random()*(N-a0-a1-a2));
		int a4 = (int)(1+Math.random()*(N-a0-a1-a2-a3));
		int a5 = (int)(1+Math.random()*(N-a0-a1-a2-a3-a4));
		int A[] = {a0,a1,a2,a3,a4,a5};	
		int b0 = (int)(1+Math.random()*(N));
		int b1 = (int)(1+Math.random()*(N-b0));
		int b2 = (int)(1+Math.random()*(N-b0-b1));
		int b3 = (int)(1+Math.random()*(N-b0-b1-b2));
		int b4 = (int)(1+Math.random()*(N-b0-b1-b2-b3));
		int b5 = (int)(1+Math.random()*(N-b0-b1-b2-b3-b4));
		int B[] = {b0,b1,b2,b3,b4,b5};
	
//		System.out.print(binary(B,a0,0,5));
//		System.out.print(binary(B,a1,0,5));
//		System.out.print(binary(B,a2,0,5));
//		System.out.print(binary(B,a3,0,5));
//		System.out.print(binary(B,a4,0,5));
		binary(B,a0,0,5);
		binary(B,a1,0,5);
		binary(B,a2,0,5);
		binary(B,a3,0,5);
		binary(B,a4,0,5);
		}
		System.out.print(count);
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	//暴力查找，全lo一遍
	public static int rank(int key, int[] a){
		for(int i = 0; i < a.length; i++){
			if(a[i] == key){
				return i;
			}
		}
		return -1;	
		
	}
	
	public static int binary(int[] a,int key, int l, int r){
		if(l > r) return -1;
		int mid = (l + r) / 2;
		if(key < a[mid]) return binary(a,key,mid + 1,r);
		if(key > a[mid]) return binary(a,key,l,mid - 1);
		count++;
		return mid;
	}

	
	
}
