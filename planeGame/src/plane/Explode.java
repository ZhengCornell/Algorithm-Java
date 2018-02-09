package plane;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

public class Explode {
	double x,y;
	static Image[] imgs = new Image[10];//图片的切换,多次加载搞成static代码块，大家共享初始化
	int count = 0;
	
	static{
		for(int i = 0; i < 10; i++){
			imgs[i] = GameUtil.getImage("images/explode/T"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	public void draw(Graphics g){
		if(count > 9){
		
		}
		g.drawImage(imgs[count],(int)x,(int)y,null);
		count++;
	} 
	public Explode(double x, double y){
		this.x = x;
		this.y = y;
		
	}
	
}
