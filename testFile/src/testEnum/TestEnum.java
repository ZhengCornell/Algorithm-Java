package testEnum;

public class TestEnum {
	public enum Mycolor{red, green, blue};
	
	public static void main(String args[]){
		Mycolor m = Mycolor.red;
		switch(m){
		case red:
			System.out.println("red");
			break;
		case blue:
			System.out.println("red");
			break;
		case green:
			System.out.println("red");
			break;
		default:
			System.out.println("default");
		}
		System.out.println(m);
	}
	
}