package abstractClass;

public abstract class Animal {
	String strfeaf;
	public abstract void run();
	public void breath(){
		System.out.println("gan!");
		run();//从猫狗对象里找啊！//
	}
	
}

class Cat extends Animal{

	@Override
	public void run() {
		System.out.println("猫步小跑");
		
	}
	
}
class Dog extends Animal{

	@Override
	public void run() {
		System.out.println("狗步小跑");
		
	}
	
}