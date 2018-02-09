package hashmap;

import java.util.ArrayList;
import java.util.List;

public class People {
	private String name;
	private List<Rich> rl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Rich> getRl() {
		return rl;
	}
	public void setRl(List<Rich> rl) {
		this.rl = rl;
	}
	public People(String name, List<Rich> rl) {
		super();
		this.name = name;
		this.rl = rl;
	}
	public People(){
		rl = new ArrayList<Rich>();
	}
	public People(String name){
		this();
		this.name = name;
	}
	
	
	
	
	
}
