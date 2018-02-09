package atraining;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a ={11,3,4,6,7,4,5,2,8};
		int min = 0;
		int temp;
		for(int i = 0; i < a.length - 1; i++){
			min = i;
			for(int j = i+1; j < a.length; j++){
				if(a[min]>a[j]){
					min = j;
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
//	
//	交换操作 0～n-1
//	比较操作 (n-1)*n/2
//	赋值操作 0～3(n-1)
//	
	
	
	
	
	
	
	}

}
