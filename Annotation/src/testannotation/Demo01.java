package testannotation;

import java.util.Date;

public class Demo01 extends Object {
	
	@Override//表示这个方法重写了父类方法//
	public String toString(){
		return "";
	}
	
	public static void main(String args[]){
		Date d = new Date(System.currentTimeMillis()+10*1000);
		d.parse(null);
		
	}
}
