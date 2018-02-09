package main;

public class Student {
	String name;
	int id;
	
	static int ss;
	
	public static void printSS(){
		System.out.println(ss);
	}
	public void study(){
		printSS();
		System.out.println(name + "1");
	}
	
	public void sayHello(String dd){
		System.out.println(name + dd);
	}
}
