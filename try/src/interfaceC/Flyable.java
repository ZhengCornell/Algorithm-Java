package interfaceC;

public interface Flyable {
	int MAX_SPEED = 11000;
	int MIN_HEIGHT = 1;
	/*public abstract*/ void fly();
}

interface Attack{
	void attack();
}

class Plane implements Flyable{

	@Override
	public void fly() {
		System.out.println("发动机");
		
	}
	
}

class Man implements Flyable, Attack{
	int weight = 0;
	@Override
	public void fly() {
		System.out.println("跳起来");
		
	}
	public void attack(){
		System.out.println("敲");
	}
	
}
