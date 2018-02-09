package test;
import java.awt.Color;
import java.awt.Font;
//写完后封装
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameFrame extends Frame {
	
	Image img = GameUtil.getImage("images/528039-z.jpg");
	
	public void launchFrame(){//方法1：搭建窗口(位置，宽度高度)
		setSize(500,500);//先宽再高
		setLocation(100,100);
		setVisible(true);	
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	} 
	private double x = 100, y = 100;
	private double degree = 1;
	private double speed = 30;
	@Override
		public void paint(Graphics g) {//方法2：画画，画完改回来
		System.out.println("ri");
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
			speed -= 5;
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
//		ps如何缩小图片
	}
	//定义重画窗口的线程类，是个普通内部类，便于访问外部类属性//
	class PaintThread extends Thread{//线程
			public void run(){
				while(true){
					repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	}

	public static void main(String args[]){
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
	
}
