package testEte1;

public class Ete1 {
	public static void main(String args[]){
//		int i = 1/0;
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Computer c = new Computer(); ;
		
		c.start();
		
	}
}

class Computer{
	void start(){
		System.out.println("1");
	}
}



