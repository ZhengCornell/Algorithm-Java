package PCP;
//一个场景，共同资源
//生产者消费者模式，采用信号灯法。需要标示。全在共同资源内操作
public class Movie {
	private String pic;
	//true:生产者生产，消费者等待，生产完后消费 notify 和 wait 与同步一起使用
	//false:消费者消费生产者等待，消费完后生产
	
	private boolean flag = true;
	
	public synchronized void play(String pic){
		if(!flag){//生产者player等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//生产完毕
		
		this.pic = pic;
		System.out.println("生产了" + pic);
		//通知消费者
		this.notify();
		//生产者停下
		this.flag = false;
	}
	
	public synchronized void watch(){
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("消费了" + pic);
		this.notifyAll();//通知所有生产者
		this.flag = true;	
	
	}

}
