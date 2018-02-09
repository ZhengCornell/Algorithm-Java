package princeton.day2;

public class InsertionSort {
	public static void main(String args[]){
		int[] a = {4,3,5,2,9,5,22,63};
		InsSort(a);
	}
	public static void InsSort(int[] a){
		int n = a.length;
		
		for(int i = 0; i < n; i++){
			for(int j = i; j > 0; j--){
				if(less(a[j-1],a[j])) break;
				exch(a,j-1,j);
			}
		}
		for(int k = 0; k < n; k++){
			System.out.print(a[k]+" ");
		}
	}
	
	
	
	
	
	public static void exch(int[] a, int i, int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	public static boolean less(int a, int b){
		if(a <= b) return true;
		else return false;
	}

}
