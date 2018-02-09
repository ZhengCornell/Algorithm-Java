package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.Constant;

public class Bullet extends GameObject{
	double degree;
	private boolean live = true;
	public Bullet(){
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 30;
		height = 30;
		degree = Math.random()*Math.PI*2;
	}
	
	public void hua(Graphics g){
		if(live){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
//		g.fillOval(0,0,width,height);
//		g.fillOval(50,0,width,height);
//		g.fillOval(100,0,width,height);
//		g.fillOval(150,0,width,height);
//		g.fillOval(200,0,width,height);
//		g.fillOval(250,0,width,height);
//		g.fillOval(300,0,width,height);
//		
		speed = 3;
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		move();
		g.setColor(c);
	}}
	public void move(){
		if(y > Constant.GAME_HEIGHT - height || y < width){
			degree = -degree;
		}
		
		if(x < width || x > Constant.GAME_WIDTH - width){
			degree = Math.PI - degree;
		}
		
		
	}
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}


}
