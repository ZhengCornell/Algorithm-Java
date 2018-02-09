package atraining;

public class InsertSort {//直插

	public static void main(String[] args) {
		int[] a = {1,3,5,7,8,9};
		int key = 6;
		long d = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
		test02(a,key);
		}
		long d2 = System.currentTimeMillis();
		long d3 = d2-d;
		System.out.println("\r"+d3);
		}
	
	
	public static void test01(int[] a, int key){
		int[] c = new int[a.length+1];
		int i = 0;
		for(i = 0 ; i < a.length; i++){
			if(a[i] < key){
				c[i] = a[i];
			}else{
				c[i] = key;
				break;
			}
		}
		for(;i<a.length;i++){
			c[i+1]=a[i];
		}
		
//		System.out.println(i);
		
		for(int j = 0; j < c.length; j++){
			System.out.print(c[j]+" ");
		}
		
	}

	public static void test02(int[] a, int key){
		int n = a.length/2;
		int[] c = new int[a.length+1];
		int[] d = new int[a.length+1];
		int i = 0,j = 0;
		if(key < a[n]){
			for(i = 0; i <= n; i++){
				if(a[i] < key){
					c[i] = a[i];
				}else{
					c[i] = key;
					break;
				}
			}
			for(;i<a.length;i++){
				c[i+1] = a[i];
			}
		}else{
			for(int m = 0;m<=n;m++){
				d[m] = a[m];
			}
			for(j = n+1; j < a.length; j++){
				if(a[j] < key){
					d[j] = a[j];
				}else{
					d[j] = key;
					break;
				}
			}
			for(;j<a.length;j++){
				d[j+1] = d[j];
			}
		}
		for(int l = 0; l < c.length; l++){
			System.out.print(c[l]+" ");
		}
	}





}
