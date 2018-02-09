package princeton.day3;

public class QuickSortForDuplicateKey {
	private static void sort(int[] a,int lo, int hi){
		if(hi<=lo) return;
		int lt = lo, gt = hi;
		int v = a[lo];
		int i = lo;
		while(i<=gt){
			if (i < v) exch(a,lt++,i++);
			else if(i > v) exch(a,gt--,i);
			else i++;
		}
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	

	
	public static void exch(int[] a, int i, int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

}
