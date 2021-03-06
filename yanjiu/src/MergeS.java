
public class MergeS {
	private static int[] temp;
	public static void main(String[] args){
		int[] a = {24,18,49,23,35,34,27,63,5};
	
		
		Msort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void Msort(int[] a){

		temp = new int[a.length];
		Msort(a,temp,0,a.length-1);
	}
	
	public static void Msort(int[] a, int[] temp,int l, int r){
		if(l>=r){
			return;
		}
		int m = l + (r - l) /2;
		Msort(a,temp,l,m);
		Msort(a,temp,m+1,r);
		
		merge(a,temp,l,m,r);
	}
	private static void merge(int[]a,int[] temp,int l, int m, int r){
		
		for(int k = l; k <= r; k++){
			temp[k] = a[k];
		}
		int i = l;
		int j = m + 1;
		for(int k = l; k <= r; k++){
			if(i > m) {
				a[k] = temp[j];
				j = j + 1;
			}
			else if(j > r){
				a[k] = temp[i++];
			}
			else if(temp[j] < temp[i]) {
				a[k] = temp[j++];
			}
			else {
				a[k] = temp[i++];
			}
			
			
		}
		
	}
	
}
