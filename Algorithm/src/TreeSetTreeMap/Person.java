package TreeSetTreeMap;

public class Person {
	private final String name;
	private final int handsome;
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getHandsome() {
		return handsome;
	}
//	public void setHandsome(int handsome) {
//		this.handsome = handsome;
//	}
	public Person(String name, int handsome) {
		super();
		this.name = name;
		this.handsome = handsome;
	}
	
	public Person(){
		name = null;
		handsome = 0;
	}
	@Override
	public String toString() {// TODO Auto-generated method stub
		return "name"+this.name+"handsome"+this.handsome+"\n";
	}
	
}
