package TreeSetTreeMap;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		Person p1 = new Person("aaa",100);
		Person p2 = new Person("bbb",200);
		Person p3 = new Person("ccc",300);
		Person p4 = new Person("ddd",400);
		
		TreeMap<Person,String> m = new TreeMap<Person,String>(
				new java.util.Comparator<Person>(){

					@Override
					public int compare(Person o1, Person o2) {
						return -(o1.getHandsome()-o2.getHandsome());
					}
					
				}
				);
		m.put(p1,"v");
		m.put(p2,"v");
		m.put(p3,"v");
		m.put(p4,"v");
	
	//使用entryset 或 keySet
	Set<Person> s = m.keySet();
	System.out.println(s);
}
}
