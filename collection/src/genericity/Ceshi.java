package genericity;

public class Ceshi {
	public static <M> void test(T t){
		System.out.println(t);
	}
	public static void main(String args[]){
		test("111");
		
	}
}
