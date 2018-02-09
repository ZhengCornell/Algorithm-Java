package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Planet extends Star {
	//图片，坐标 + 椭圆轨迹运行，速度，圆心
	double longAxis;//长短轴
	double shortAxis;
	double speed;
	double degree = 0;
	Star center;
	boolean satellite;
	
	
	
	public void hua(Graphics g){
		super.hua(g);
		
//		g.drawImage(img, (int)x, (int)y, null);//画上去叻
		
		move();
		if(satellite != true){
			drawTrace(g);
		}
		
	
	}
	public void drawTrace(Graphics g){
		double _x,_y,_width,_height;
		Color c = g.getColor();
		g.setColor(Color.blue);
		_width = longAxis*2;
		_height = shortAxis*2;
		_x = center.x + center.width/2 - longAxis;
		_y = center.y + center.height/2 - shortAxis;
		g.drawOval((int)_x,(int)_y,(int)_width,(int)_height);
		g.setColor(c);
	}
	
	public void move(){
		x = (center.x + center.width/2) + longAxis*Math.cos(degree);
		y = (center.y + center.height/2) + shortAxis*Math.sin(degree);
		
		degree += speed;
	}
	
		//作为一个子类的构造器，必然会引用父类构造器，所以父类构造器里搞一个空的
		public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		
		this.img = GameUtil.getImage(imgpath);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
		}
		public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed, boolean satellite) {
			this(center,imgpath,longAxis,shortAxis,speed);
			this.satellite = satellite;
			}
	//构造器每个子类自己写，用super引到父类去,构造器必然需要重载
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
	

	
	
}
