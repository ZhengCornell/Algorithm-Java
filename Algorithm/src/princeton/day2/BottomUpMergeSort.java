package princeton.day2;

public class BottomUpMergeSort {
	private static int[] aux;
	public static void sort(int[] a){
		int N = a.length;
		aux = new int[N];
		for(int sz = 1; sz < N; sz = sz*2){
			for(int lo = 0; lo < N-sz; lo = lo + sz*2){
				merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
			}
		}
		for(int i = 0; i < N; i++){
			System.out.print(a[i]);
		}
	}
	
	
	private static void merge(int[] a,int[] aux, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		for(int d = lo; d <= hi; d++){
			aux[d] = a[d];//用aux装满， 返回给a
		}
		
		for(int k = lo; k <= hi; k++){
			if(i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (aux[j] < aux[i]) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		
	}
	
	public static void main(String[] args){
		int[] a = {7,3,5,7,6,2};
		
		sort(a);
		
	}
}
