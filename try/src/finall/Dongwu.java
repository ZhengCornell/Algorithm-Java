package finall;


public /*final 这个类不能被继承*/ class Dongwu /*extends Object*/{
	String eye;
	public /*final 不能被子类重写*/ void run(){

		System.out.println("5");
	}
	public void eat(){
		System.out.println("eat!");
		}
	public void sleep(){
		System.out.println("sleep!");
	}
	public Dongwu(){
		super();
		System.out.println("2");
	}
}

class Bird extends Dongwu{
	public void run(){
		System.out.println("6");
	}
	public void ovipary(){
		System.out.println("ovipary!");
	}
	public Bird(){
		super();//可有可无//
		System.out.println("3");
	}
}