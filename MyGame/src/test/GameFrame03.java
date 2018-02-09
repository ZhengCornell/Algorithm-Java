package test;
//写完后封装
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame03 extends Frame {
	
		
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
		private double degree = 3.14/2;//[0,2pi]
		@Override
			public void paint(Graphics g) {//方法2：画画，画完改回来
			
			System.out.println("11111");
			g.drawImage(img,(int)x,(int)y,null);//变量代替坐标
			x += 3*Math.cos(degree);
			y += 3*Math.sin(degree);
			
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
			GameFrame03 gf = new GameFrame03();
			gf.launchFrame();
		}
		
}


