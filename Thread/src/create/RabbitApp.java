package create;

public class RabbitApp {

	public static void main(String[] args) {
//		使用线程:创建子类对象
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
//		调用start方法 若是调用run，则是普通方法调用
//		rab.start();//这是Rabbit 父类Thread 的方法，线程启动
//		tor.start();
		rab.run();
		tor.run();
		for(int i = 0; i < 20; i++){
			System.out.println("main" + i);
		}
	}

}
