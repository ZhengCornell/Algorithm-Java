package leee;	
/*递推*/
public class Ditui {
	public static void main(String args[]){
	int a[] = new int[13];
	int i;
	a[0] = 1;
	a[1] = 1;
	for(i = 2;i <= 12;i++){
		a[i]=a[i-2]+a[i-1];
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
	System.out.print(a[9]);
	System.out.print(a[10]);
	System.out.print(a[11]);
	System.out.print(a[12]);
	}
}
