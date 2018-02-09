package main;

public class Overload {
	public static void main(String args[]){
	MyMath m = new MyMath();
	int res = m.add(4.2,5);
	int yue = m.add(4,5,6);
	System.out.println(res);
	System.out.println(yue);
	
	}
}
	

class MyMath{
	int a;
	int b;
	public MyMath(){
		
	}
	public MyMath(int a){
		this.a = a;//this.a外面的a，a形参//
	}
	public MyMath 
	public int add(int b, double a){
		return (int)a+b;
	}
	public int add(double a, int b){
		return (int)a+b;
	}
	public int add(int a, int b, int c){
		return a+b+c;
	}
}


