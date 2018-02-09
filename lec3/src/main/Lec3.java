package main;

public class Lec3 {
	public static void main(String args[]) {
	int n = 1234, res, i, k=5;
	int a[] = new int[4];
	for(i=3; i >= 0; i--) {
		res = n % 10;
		a[i]= res;
		k = n / 10;
		System.out.println(a[3]);
	}
	}
}