package leee;
/*冒泡*/
public class Maopao {
	public static void main(String args[]) {
	int a[] = {3,5,6,8,3,1,5};
	int min,i,j;
	for(i=0;i<a.length;i++){
		for(j=6;j>=(i+1);j--){
			if(a[j]<a[j-1]){
				min=a[j];
				a[j]=a[j-1];
				a[j-1]=min;
			}
		}
	}
	System.out.print(a[0]);
	System.out.print(a[1]);
	System.out.print(a[2]);
	System.out.print(a[3]);
	System.out.print(a[4]);
	System.out.print(a[5]);
	System.out.print(a[6]);
	}
}
