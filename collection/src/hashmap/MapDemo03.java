package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//面向对象 ＋ 分拣存储
//模拟考试：放入测试数据进入  
public class MapDemo03 {
	public static void main(String args[]){	
		List<Student> l = exam();
		Map<String,ClassRoom> m = count(l);
		view(m);
		
		
	}
	
//	1.创建考试
	public static List<Student> exam(){
		List<Student> stulist = new ArrayList<Student>();
		stulist.add(new Student("gz","a",95));
		stulist.add(new Student("wz","a",90));
		stulist.add(new Student("kz","b",65));
		stulist.add(new Student("dz","b",75));
		stulist.add(new Student("ez","c",85));
		stulist.add(new Student("mz","c",25));
		return stulist;
	}
//	2.统计分析（面向对象，分拣存储）
//	进一堆list数据，出来一个Map
	public static Map<String,ClassRoom> count(List<Student> l){
		Map<String,ClassRoom> m = new HashMap<String,ClassRoom>();
		for(Student stu:l){
			String no = stu.getNo();
			double score = stu.getScore();
			ClassRoom c = m.get(no);
			if(c == null){
				c = new ClassRoom(no);
				m.put(no,c);
			}
			c.setTotal(c.getTotal()+stu.getScore());
			c.getStulist().add(stu);
		}
		return m;
	}
//	3.查看总分平均分 进Map.
	public static void view(Map<String,ClassRoom> m){
		Set<String> k = m.keySet();
		Iterator<String> i = k.iterator();
		while(i.hasNext()){
			String no = i.next();
			ClassRoom c = m.get(no);
			double total = c.getTotal();
			double avg = total/c.getStulist().size();
			System.out.println(no+total+avg);
		
		
		}
		
		
		
		
		
	}
	
	
	
}
