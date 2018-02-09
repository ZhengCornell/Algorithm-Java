package create;
//重写run方法（线程体） 一切从run开始

public class Rabbit extends Thread {

	@Override
	public void run() {
		for(int i = 0; i< 10; i++){
			System.out.println("兔子跑了"+i+"步");
		}
	}	
	
}

class Tortoise extends Thread {

	@Override
	public void run() {
		for(int i = 0; i< 10; i++){
			System.out.println("乌龟跑了"+i+"步");
		}
	}	
	
}
