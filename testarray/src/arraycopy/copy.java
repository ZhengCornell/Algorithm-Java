package arraycopy;

public class copy {
	public static void main(String args[]){
	int[] a = {3,1,6,2,9,0,7,4,5,8};
	int temp;
	int k = 7;
	
	
	for(int i = 0; i < a.length; i++){
		for(int j = 0; j < a.length - i - 1; j++){
			if(a[j]>a[j+1]){
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}else{
				
			}
		}
	}
	for(int j:a){
		System.out.println(j);
	}
} 
}
