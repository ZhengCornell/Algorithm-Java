package atraining;
import java.lang.Integer;
import java.lang.Double;
public class Demo01 {
	private static int count1 = 0;
	public static void main(String[] args) {
//		System.out.println(test01(27,4));
////		System.out.println(sushu(27));
		int[] a = {0,1,2,3,4,5};
//		int key = 4;
		int n = rank(4,a,0,4);
		System.out.println(n);
		System.out.println(count1);
//		String str = "55 55";
//		Integer k = new Integer("544fg534");
//		int l = k.parseInt(str);
//		Integer i = new Integer(5);
//		String k = i.toString();
//		System.out.println(k);
	}
	
	
	public static int test01(int a, int b){
		int c;
		if(b == 0){
			return a;
		}
		c = a % b;
		
		
		return test01(b,c);
	}
	public static boolean sushu(int a){
		boolean flag = true;
		if(a<=1){
			flag = false;
		}else{
			for(int i = 2;i*i <= a; i++){
				if(a % i == 0){
					flag = false;
					break;
				}
				
			}
		}
		
		return flag;
	}
	public static int rank(int key,int[] a, int x, int y){
		
		if(x>y) {
			count1++;
			
			return 0000000;
		}
		int mid = x + (y-x)/2;
			
		
			if(key < a[mid]){
				count1++;
				return rank(key,a,x,mid-1);}
			else if(key > a[mid]){count1++;return rank(key,a,mid+1,y);}
			else{count1++;return mid;}
		
	
	}
//	public static double binomial(int x, int y, doule p){
//		
//	}


}
