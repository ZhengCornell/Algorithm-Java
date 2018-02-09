package solar;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Star {
	Image img;
	double x,y;
	int width, height;
	
	public void hua(Graphics g){//这个hua的方法，太宽泛，子类直接重写！
		g.drawImage(img, (int)x, (int)y, null);
	}
	//用构造器
	public Star(Image img, double x, double y){
		this(img);//直接调用本类的另一个构造器
		this.y = y;
		this.x = x;
		
		
	}
	
	public Star(String imgpath, double x, double y){
//		this.img = GameUtil.getImage(imgpath);
//		this.y = y;
//		this.x = x;
		this(GameUtil.getImage(imgpath),x,y);//this.调用上面那个构造方法
	}
	
	public Star(){
		//公用的空构造器，子类什么鸡吧都可以super到这里来
	}
	public Star(Image img){
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
}
