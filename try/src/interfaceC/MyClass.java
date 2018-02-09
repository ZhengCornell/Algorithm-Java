package interfaceC;

public class MyClass implements MyInterface {

	@Override
	public void test01() {
		String d;
		d = MyInterface.MAX_VALUE;
		System.out.println(d);
		
	}

	@Override
	public int test02(int a, int b) {
		System.out.println("yue");
		return a+b;
	}
}
