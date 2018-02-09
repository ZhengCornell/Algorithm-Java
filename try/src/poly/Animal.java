package poly;

public class Animal {
	String str;
	int i;
	public void voice(){
		System.out.println("普通叫声");

	}

}

class Cat extends Animal {
	public void voice(){
		super.voice();
		System.out.println("喵喵喵");
	}
	public void catchMouse(){
		System.out.println("抓耗子");
	}
	
}
class Dog extends Animal {
	public void voice(){
		System.out.println("汪汪汪");
	}
	public void seeDoor(){
		System.out.println("看门");
	}
}
class Pig extends Animal {
	public void voice(){
		System.out.println("猪猪猪");
	}
	
}