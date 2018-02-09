package hashmap;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private String no;
	private List<Student> stulist;
//	学生列表应随班级创建而产生，这边已经设置了引用，直接给地址
	private double total;
	
	public ClassRoom(){
		stulist = new ArrayList<Student>();
	}
	public ClassRoom(String no){
		this();
		this.no = no;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStulist() {
		return stulist;
	}
	public void setStulist(List<Student> stulist) {
		this.stulist = stulist;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ClassRoom(String no, List<Student> stulist, double total) {
		super();
		this.no = no;
		this.stulist = stulist;
		this.total = total;
	}
	
	
}
