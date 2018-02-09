package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import util.Constant;
import util.GameUtil;

public class Plane extends GameObject {
	int speed = 5;
	private boolean live = true;
	
	private boolean left,up,right,down;//一开始都是false
	
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,img.getWidth(null),img.getHeight(null));
		return r;
	}
	public void draw(Graphics g){
		if(live){
		g.drawImage(img,(int)x,(int)y,null);
		move();
		}
	}
	public Plane(String imgpath, double x, double y){
		super();
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	public Plane(){
		
	}
	
	//生死的set get 方法
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void move(){
		if(left && x > width){
			x -= speed;
		}
		if(right && x < Constant.GAME_WIDTH - width){
			x += speed;
		}
		if(up && y > height){
			y -= speed;
		}
		if(down && y < Constant.GAME_HEIGHT - height){
			y += speed;
		}

		}
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	
	public void minusDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		
		}
	}
		
		
	
}