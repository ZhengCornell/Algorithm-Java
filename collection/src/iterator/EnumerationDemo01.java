package iterator;

import java.util.Enumeration;
import java.util.Vector;

//判断hasMoreElements（）
//获取nextElement（）
//Vector 的 elements 方法
public class EnumerationDemo01 {
	public static void main(String args[]){
		Vector<String> v = new Vector<String>();
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");
		//遍历Vector
		Enumeration<String> en = v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
