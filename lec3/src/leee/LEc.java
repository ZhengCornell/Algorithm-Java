package leee;
/*插入排序算法*/
public class LEc {
	public static void main(String args[]) {
	int a[] = {5,2,4,6,1,3,5};
	int i,j,min;
	for(j=1;j<a.length;j++){
		for(i=0;i<j;i++){
			if(a[j]<a[i]){
				min=a[j];
				a[j]=a[i];
				a[i]=min;
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
