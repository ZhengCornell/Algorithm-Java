package princeton.day2;

public class SelectionSort {
	
	public static void main(String args[]){
		int[] a = {4,3,5,2,9,5,22,63};
		selSort(a);
	}
	public static void selSort(int[] a){
		int n = a.length;
		for(int i = 0; i < n; i++){
			int min = i;
			for(int j = i+1; j < n; j++){
				if(less(a[j],a[min])){
					min = j;
				}
			}
			exch(a,i,min);
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
