package callback;

public interface MyFrame {
	public abstract void paint();
}
interface IMyFrame{
	void paint();
}

class GameFrame01 implements IMyFrame{
	public void paint(){
		System.out.println("画出窗口01");
	}
}

class GameFrame02 implements IMyFrame{
	public void paint(){
		System.out.println("画出窗口02");
	}
}

