package interfaceC;

public class Test01 {
	public static void main(String args[]){
	Flyable m = new Man();
	m.fly();
	Man m2 = (Man)m;
	m2.attack();
	
	}
}
