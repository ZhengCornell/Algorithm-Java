package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mayun {

	public static void main(String[] args) {
		List<Rich> l = test();
		Map<String,People> m = count(l);
		view(m);
	}
	
	
	public static void view(Map<String,People> m){
		Set<String> k = m.keySet();
		Iterator<String> i = k.iterator();
		while(i.hasNext()){
			String name = i.next();
			People p = m.get(name);
			List g = p.getRl();
			String money = ((Rich) g).getMoney();
			String time = ((Rich) g).getTime();
			System.out.println(name+money+time);
		}
	}
	
	public static Map<String,People> count(List<Rich> l){
		Map<String,People> m = new HashMap<String,People>();
		for(Rich r:l){
			String money = r.getMoney();
			String name = r.getName();
			String time = r.getTime();
			
			People p = m.get(name);
			if(p == null){
				p = new People(name);
				m.put(name,p);
			}
			p.getRl().add(r);
		}
		
		return m;
	}
	public static List<Rich> test(){
		List<Rich> l = new ArrayList<Rich>();
		l.add(new Rich("50E","my","2012"));
		l.add(new Rich("100E","wjl","2012"));
		l.add(new Rich("0","gz","2012"));
		l.add(new Rich("1000E","my","2017"));
		l.add(new Rich("900E","wjl","2017"));
		l.add(new Rich("100","gz","2017"));
		return l;
	}
	
	

}
