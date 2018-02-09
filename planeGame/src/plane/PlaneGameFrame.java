
package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import util.GameUtil;
import util.MyFrame;
//飞机游戏主窗口
public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.png");
	Plane p = new Plane("images/2.jpg",50,50);
	//多个子弹怎么画？数组？扩容算法//初始化加载窗口的时候放子弹
	ArrayList bulletList = new ArrayList();
	Date startTime;
	Date endTime;
	int m = 0;
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		p.draw(g);
		//画子弹在这里
		for(int i = 0; i<bulletList.size(); i++){
			Bullet b = (Bullet) bulletList.get(i);
			b.hua(g);
			//检测与飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng && m == 0){
				p.setLive(false);//飞机死
				System.out.println("u dead idiot");//加逻辑 
				endTime = new Date();
				Explode e = new Explode(p.x, p.y);
	
				e.draw(g);
				m++;
			}
		}
		if(!p.isLive()){
//			printInfo(g,"灭亡",50,100,280,Color.white);
		
		int t = (int)(endTime.getTime() - startTime.getTime())/1000;
		printInfo(g,"生存时间" + t +"秒",20, 120,200,Color.white);
		switch(t/10){
		case 0:
		case 1:
			printInfo(g,"你是废物",50,80,250, Color.white);
			break;
		case 2:
			printInfo(g,"niubi",50,80,250, Color.white);
			break;
		default:
			break;
		}
		
		}
//		printInfo(g,"分数：100",30,50,50,Color.green);
		
	}
	public void printInfo(Graphics g, String str, int size, int x, int y, Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x,y);
		
		g.setColor(c);
	}
//	public void printInfoGameOver(Graphics g, String str, int size){
//		Color c = g.getColor();
//		g.setColor(Color.white);
//		Font f = new Font("宋体",Font.BOLD,size);
//		g.setFont(f);
//		g.drawString(str,100,280);
//		
//		g.setColor(c);
//	}
	
	public static void main(String args[]){
		new PlaneGameFrame().launchFrame();
	}
	public void launchFrame(){
		super.launchFrame();
		addKeyListener(new KeyMonitor());//键盘监听
		//生成子弹
		for(int i = 0; i <= 50; i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
		
	}
	//定义为内部类实用外部类普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("按下："+e.getKeyCode());
			p.addDirection(e);		
		}
			

		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("释放："+e.getKeyCode());
			p.minusDirection(e);
		}
		
	}
	
}
