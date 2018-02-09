package hashmap;

public class Rich {
	private String money;
	private String name;
	private String time;
	public Rich(String money, String name, String time) {
		super();
		this.money = money;
		this.name = name;
		this.time = time;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Rich(){
		
	}
	
}
