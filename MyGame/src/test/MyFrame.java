package test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//超级父类
import test.GameFrame.PaintThread;

public class MyFrame extends Frame {
	

	
	public void launchFrame(){//方法1：搭建窗口(位置，宽度高度)
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//先宽再高
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

}
