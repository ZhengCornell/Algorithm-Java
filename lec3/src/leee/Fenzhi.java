package leee;
/*分治*/
public class Fenzhi {
	public static void main(String args[]) {
	int i,j,k;
	int a[] = new int[9];
	int m[] = {2,3,5,7,10000};
	int n[] = {5,6,9,78,10000};
	for(i=0,j=0,k=0;i<5&&j<5;){
		if(m[i]<n[j]){
			a[k] = m[i];
			i++;
			k++;
		}
		else{
			a[k] = n[j];
			j++;
			k++;	
		}
	}
	System.out.print(a[0]);
	System.out.print(a[1]);
	System.out.print(a[2]);
	System.out.print(a[3]);
	System.out.print(a[4]);
	System.out.print(a[5]);
	System.out.print(a[6]);
	System.out.print(a[7]);
	System.out.print(a[8]);
	
	
	}
}
