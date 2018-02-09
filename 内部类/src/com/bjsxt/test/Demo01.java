package com.bjsxt.test;

public class Demo01 {
	//静态内部类     类似外部静态变量
	static class StaticNestedClass{	
	}
	//普通内部类(成员内部类)  类似外部普通变量
	private class FieldInnerClass{
	}
	void test(){
		
		//方法内部类（局部内部类）  类似局部变量
		class LocalClass{
			
		}
	
	//匿名内部类
	Runnable runnable = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}//并非直接new 接口 
//		定义一个无名内部类实现了这个接口，同时抛出匿名内部类的对象，同时重写这个对象的方法
		
	};
	
	}

}
