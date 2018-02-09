package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import util.GameUtil;
import util.MyFrame;

public class MyFrameFeiJi extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.png");
	Plane p = new Plane("images/2.jpg",200,400);
	ArrayList bulletList = new ArrayList();
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		p.draw(g);
		for(int i = 0; i<bulletList.size(); i++){
			Bullet b = (Bullet) bulletList.get(i);
			b.hua(g);
//			b.hua(g,50,0);
//			b.hua(g,100,0);
//			b.hua(g,150,0);
//			b.hua(g,200,0);
//			b.hua(g,250,0);
//			b.hua(g,300,0);
//			b.hua(g,50,0);
//			b.hua(g,100,0);
		
		
		boolean peng = b.getRect().intersects(p.getRect());
		if(peng){
			b.setLive(false);
		}
		}
	}
	
	public static void main(String args[]){
		new MyFrameFeiJi().launchFrame();
	}
	
	public void launchFrame(){
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		for(int i = 0; i <= 20; i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
	}
	

	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
		
	}
	



}
