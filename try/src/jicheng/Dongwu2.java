package jicheng;

public class Dongwu2 {
	String eye;
	public void run(){
		System.out.println("跑跑！");
	}
	public void eat(){
		System.out.println("eat!");
	}
	public Dongwu2(){
		super();
		System.out.println("创建一个动物！");
	}
}

class Mammal2{
	Dongwu2  k = new Dongwu2();
	public void taisheng(){
		System.out.println("我是胎生");
	}
}
class Bird2{
	Dongwu2 k = new Dongwu2();
	public void run(){

		System.out.println("我是一个小小小鸟！");
	}
	public Bird2(){
		System.out.println("建一个鸟");
	}

}
	