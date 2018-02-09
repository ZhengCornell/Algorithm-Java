package princeton.day1;

public class Binary {
	public static void main(String args[]){
		
	}
	
	
	
	
	public static int binary(int[] a, int k,int l, int r){
	if(l > r) return -1;
	
	else{
	int mid = (l + r)/2;
	
	if(a[mid] < k) return binary(a,k,mid+1,r);
	else if(a[mid] > k) return binary(a,k,l,mid);
	else return mid;
	}	
	}

	public static int binary2(int[] a, int k){
		int l = 0, r = a.length -1;
		while(l <= r){
		int m = (l+r)/2;
		if(k < a[m]) r = m - 1;
		else if(k > a[m]) l = m + 1;
		else return m;
		}
		return -1;
	}
}
