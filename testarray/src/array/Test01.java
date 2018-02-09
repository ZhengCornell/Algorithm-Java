package array;

public class Test01 {
	public static void main(String args[]){
		int[] a = new int[3];
		a[1]=28;
		a[2]=32;
		
		
		Car k[] = {new Car("1"), new Car("2")};
		
		System.out.println(k[0].name);
		System.out.println(a.length);
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
}
