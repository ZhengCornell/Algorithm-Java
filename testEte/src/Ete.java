

package ete;


public class Ete {
	public static void main(String args[]){
//		int i = 1/0;
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Computer c = null ;
		if(c != null){
		c.start();
		}
	}
}

class Computer{
	void start(){
		System.out.println("1");
	}
}