package poly;

public class Test {

	public static void testVoice(Animal b){//包含了所有子类//
		b.voice();
		if(b instanceof Cat/*b是cat类的对象*/){
			((Cat) b).catchMouse();//此时若引用猫对象进入方法则额外输出这个方法的结果//
		}
	}
	
	
	
	public static void main(String agrs[]){
		//Animal m = new Cat();
		//Cat m2 = (Cat)m;
		//testVoice(m)//
		
		Animal m = new Cat(); 
	
	
		testVoice(m);
		//只写了Animal方法区，m猫对象只有这个方法的地址却找不到方法区中animal类的方法//
		Animal n = new Dog();
		Dog k = (Dog)n;
		testVoice(n);
		k.seeDoor();
	}
	
}
