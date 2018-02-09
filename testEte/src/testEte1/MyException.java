package testEte1;

public class MyException extends Exception {
	public MyException(){
		
	}
	
	public MyException(String str){
		super(str);//调父类引用
	}
}

class TestMyException{
	String test() throws MyException{
		return "5555";
	}
	public static void main(String args[]){
		try {
			TestMyException d = new TestMyException();
			String m = d.test();
			System.out.println(m);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
