package princeton.day2;

public class MergeSort {
		public static void main(String[] args){
			int[] a = { 3, 2, 1 ,2 ,99,3,4,5 };
			merge(a,0,a.length);
		}
	
	private static void merge(int[] a, int l, int r){
		int[] temp = new int[a.length];
		for(int k = l; k < r; k++){
			temp[k] = a[k];
		}
		int m =( l + r-1) /2;
		int i = l; 
		int j = m + 1;
		for(int o = l; o < r; o++){
			if(i > m) a[o] = temp[j++];
			else if (j > r) a[o] = temp[i++];
			else if (temp[j] < temp[i]) a[o] = temp[j++];
			else a[o] = temp[i++];
		}
		for(int f = 0; f < a.length; f++){
			System.out.println(a[f]);
		}
		
		
		
	}
	
	public static boolean isSorted(int[] a, int l, int r){
		for(int i = l; i <= r; i++){
			if(a[i] > a[i+1]){
				return false;
			}
			
		}
		return true;
	}
}
