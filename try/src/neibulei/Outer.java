package neibulei;

public class Outer {
	public static void main(String args[]){
		Face f = new Face();
		Face.Nose n = f.new Nose();
		n.breath();
		
		Face.Ear e = new Face.Ear();
		e.listen();
		
	}
}

class Face{
	int type;
	String shape = "nihao";
	static String color = "red";
	
	class Nose{
		String type;

		void breath(){
			System.out.println(shape);
			System.out.println(Face.this.type);//Face.this.type//
			System.out.println("呼吸");
		}
	}
	static class Ear{
		void listen(){
			System.out.println(color);
			
		}
	}
}