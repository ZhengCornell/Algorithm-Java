package TreeSetTreeMap;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		Person p1 = new Person("aaa",100);
		Person p2 = new Person("bbb",200);
		Person p3 = new Person("ccc",300);
		Person p4 = new Person("ddd",400);
		//放入TreeSet容器中，使用业务类解耦(匿名内部类)
		TreeSet<Person> p = new TreeSet<Person>(
				new java.util.Comparator<Person>(){

					@Override
					public int compare(Person o1, Person o2) {
						
						return o1.getHandsome()-o2.getHandsome();
					}
					 
				}
				);
		p.add(p1);
		//TreeSet 在添加数据时就开始排序了，所以必须写好排序方法再放东西
		p.add(p2);
		p.add(p3);
		p.add(p4);
		System.out.println(p);
		//改变数据,此时更改已经晚了
//		p4.setHandsome(100);
//		p4.setName("aaa");	
		//此时p4和p1内容重复了(直接用final卡死)
		System.out.println(p);
	}

}
