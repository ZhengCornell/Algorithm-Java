package oritented.oop;

import static1.Student;

public class Test1 {
	public static void main(String args[]){//跑起来,逻辑上main方法和class无关//
		//通过class loader 加载Student 类。加载后方法区中有了Student 类的信息//
		Student s1 = new Student();//s1 是对象的变量名,内部属性已经初始化 包含class里的内容,接下来操作它//
		
		s1.name = "wo";//给s1 内部的 name 赋值//
		s1.study();//给s1 执行方法//
		
		s1.sayHello("dfejef");
		Student s2 = new Student();
		s2.age = 18;
		s2.name = "nimabi";
		
	}
}
