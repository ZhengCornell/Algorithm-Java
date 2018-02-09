package princeton.day2;

public class Shell {
	public static void shellSort(int[] a){
		int n = a.length;
		int h = 1;
		while(h < n/3){
			h = 3*h + 1;
		}
		while(h >= 1){
			for(int i = h; i < n; i++){
				for(int j = i; j >= h && less(a[j-h],a[j]); j -= h){//放在内部减少不必要循环
					exch(a,j-h,j);
				}
			}
			h = h/3;
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
