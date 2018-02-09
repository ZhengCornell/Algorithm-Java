package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Test01 {
	public static void main(String args[]){
		List l = new ArrayList();//AL是L的子类，子类调接口，若换C接口，不能排序了
		//ArrayList:底层实现是数组，查询快，修改慢
		//LinkedList:底层实现链表，查询慢，修改快
		//Vector:底层实现是数组，但是线程安全，效率低
		
		
		l.add("ddd");
		l.add(new Date());
		l.add(new Dog());
		l.add(1234);//包装：自动装箱了转为Integer类。
		
		System.out.println(l.size());//表示元素长度而非数组长度
		System.out.println(l.isEmpty());
		l.remove("ddd");
		System.out.println(l.size());
		
		List l2 = new ArrayList();
		l2.add("bbb");
		l2.add("ccc");
		l2.add("ccc");
		l2.addAll(l);
		System.out.println(l2.size());
		//跟顺序有关的操作
		String str = (String)l.get(0);
		System.out.println(str);
		l.set(1,"ejeje");
		System.out.println(l2);//hascode 和 equals很重要
		
		
		
		
		
	}
}

class Dog{
	
}