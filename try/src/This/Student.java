package This;

public class Student {
	String name;
	int id;
	
	public Student(String name, int id){
		this(name);
		this.name = name; 
		this.id = id;
	}
	public Student(String name){
		this.name = name;
	}
	public Student(){
		System.out.println("ri");
	}
	
	public void study(){//有个this 参数，指代当前对象，传入了对象地址//
		this.name = "zs";
		System.out.println(name + "1");
	}
	
	public void sayHello(String dd){
		System.out.println(name + dd);
	}
}
