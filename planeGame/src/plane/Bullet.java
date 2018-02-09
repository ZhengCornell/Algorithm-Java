package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Date;

import util.Constant;

public class Bullet extends GameObject{

	double degree;
	
	public Bullet(){
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 3;
		height = 3;
		
		
		
		degree = Math.random()*Math.PI*2;//随机方向飞
		
		
	}
	
	
	public void hua(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x,(int)y,width,height);
		speed = 5;
		if(speed > 0){
			speed -= 0.5;
		}else{
			speed = 0;
		}

		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		move();
		g.setColor(c);
	}
	
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
	
}
