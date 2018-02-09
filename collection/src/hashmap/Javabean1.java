package hashmap;
//javabean  存储 数据 包含setter getter访问器类
//key 是钥匙， 这个东西是箱子类，后面会用value生成对象
public class Javabean1 {
	private String name;
	private int count;
	public  Javabean1(){
		
	}
	
	public Javabean1(String name) {
		super();
		this.name = name;
	}

	public Javabean1(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
