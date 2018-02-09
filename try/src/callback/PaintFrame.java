package callback;

public class PaintFrame {
	public static void drawFrame(IMyFrame f){/*传不同子类，paint()方法不同*/
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		
		//画窗口
		f.paint();
		
		System.out.println("5");
	}
	public static void main(String args[]){
		IMyFrame m = new GameFrame01();
		IMyFrame m2 = new GameFrame02();
		drawFrame(m1);
	}
}

	