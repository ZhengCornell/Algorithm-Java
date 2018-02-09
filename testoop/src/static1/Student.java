package static1;

import oritented.oop.Computer;

public class Student {
	//数据＋行为；变量＋方法;名次对应属性，动词对应方法//
	//静态数据（属性）//
	String name;
	int id;
	int age;
	String gender;
	int weight;
	
	Computer computer;
	
	
	//动态行为//
	public void study(){
		int a;//需要自己初始化//
		System.out.println(name + "在学习");//谁再学习，需要调用数据//
	}
	public void sayHello(String b){
		System.out.println(name + b);
	}
	
	
}
