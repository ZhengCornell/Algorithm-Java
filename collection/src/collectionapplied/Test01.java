package collectionapplied;

import java.util.ArrayList;
import java.util.List;
//缺点：为了得到任何一个雇员对象中的属性，必须要针对每个属性写方法，所以采用容器更快
public class Test01 {

	public static void main(String[] args) throws Exception{//javabean
		Employ e1 = new Employ(0301,"gz",3000,"Cornell","2007-10");//一个对象一条纪录
//		e.setId(0301);
//		e.setName("gz");
//		e.setDepartment("Cornell");
//		e.setSalary(3000);
//		String startDate = "2007-10";
//		DateFormat format = new SimpleDateFormat("yyyy-MM");
//		e.setHireDate(format.parse(startDate));
		Employ e2 = new Employ(0302,"gxz",3500,"Cornell","2009-10");
		Employ e3 = new Employ(0303,"gyz",3400,"Cornell","2017-10");
		List<Employ> l = new ArrayList<Employ>();//装对象
		l.add(e1);
		l.add(e2);
		l.add(e3);
		printName(l);
		
	}
	
	public static void printName(List<Employ> l){
		for(int i = 0; i < l.size(); i++){
			System.out.println(l.get(i).getName());
		}
	}

}
