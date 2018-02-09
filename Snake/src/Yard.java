import java.awt.Frame;

public class Yard extends Frame {
	private static final int ROWS = 100;
	private static final int COLS = 100;
	private static final int BLOCK_SIZE = 5;
	
	public void launch()/*方法*/{
		this.setLocation(300, 300);
		this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE );
		this.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		new Yard().launch();

	}

}
