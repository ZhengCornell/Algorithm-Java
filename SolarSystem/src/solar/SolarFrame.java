package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.Constant;
import util.GameUtil;
import util.MyFrame;

//太阳系主窗口
public class SolarFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.PNG");
	Star sun = new Star("images/1.jpg", (Constant.GAME_WIDTH)/2, (Constant.GAME_HEIGHT)/2);
	Planet earth = new Planet(sun,"images/10.jpg",150,100,0.1);
	Planet mars = new Planet(sun,"images/2.jpg",200,130,0.15);
	Planet moon = new Planet(earth,"images/4.jpeg",30,20,0.13,true);
	
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		sun.hua(g);
		earth.hua(g);
		mars.hua(g);
		moon.hua(g);
	}
	
	public static void main(String args[]){
		new SolarFrame().launchFrame();
	}
}
