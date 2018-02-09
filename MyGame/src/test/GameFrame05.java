package test;

import java.awt.Graphics;
import java.awt.Image;

public class GameFrame05 extends MyFrame {
	Image img = GameUtil.getImage("images/528039-z.jpg");
	private double x = 100, y = 100;
	private double degree = 1;
	private double speed = 30;
	@Override
		public void paint(Graphics g) {//方法2：画画，画完改回来
		System.out.println("r2i");
//		Color c = g.getColor();
//		
//		g.setColor(Color.red);
//		g.drawLine(100,100,200,200);
//		g.drawRect(100,100,100,100);
//		g.drawOval(100,100,100,100);
//		Font f = new Font("宋体",Font.BOLD,100);
//		g.setFont(f);
//		
//		g.drawString("woshinidie",200,200);
//		g.fillRect(50,50,50,50);
//		g.setColor(c);
		g.drawImage(img,(int)x,(int)y,null);//变量代替坐标
		if(speed > 0){
			speed -=0.05;
		}else{
			speed = 0;
		}
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y > 500 - 30 || y < 30){
			degree = -degree;
		}
		
		if(x < 0 || x > 500 - 30){
			degree = Math.PI - degree;
		}
	}
	public static void main(String args[]){
		GameFrame05 gf = new GameFrame05();
		gf.launchFrame();
	}
}
