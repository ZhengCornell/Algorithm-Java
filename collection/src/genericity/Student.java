package genericity;
//Object 可以接受任意类型，因为多态
public class Student<T> {
	private T javase;
//	private G oracle;
	public Student(){
		
	}
	public T getJavase() {
		return javase;
	}

	public Student(T javase) {
		super();
		this.javase = javase;
	}

	public void setJavase(T javase) {
		this.javase = javase;
	}
	
	

	
}
