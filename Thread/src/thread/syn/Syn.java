package thread.syn;


public class Syn {

	public static void main(String[] args) {
//		真实角色
		Web12306 web = new Web12306();
//		代理（多个代理）
		Thread t1 = new Thread(web,"路人甲");
		Thread t2 = new Thread(web,"黄牛乙");
		Thread t3 = new Thread(web,"工程师");
//		开始
		t1.start();
		t2.start();
		t3.start();	
	}

}

class Web12306 implements Runnable{
	private int num = 10;
	private boolean flag = true;
	@Override
	public void run() {
	while(flag){
		test6();
	}
	}
	//线程不安全，效率高
	public void test1(){
		if(num <= 1){
			this.flag = false;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");
		num--;

	}
	
	public void test3(){
		synchronized(this){if(num <= 1){
			this.flag = false;
			return;
		}
		try {
			Thread.sleep(50);//模拟延时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = num - 1;
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");
		}
	}
	
	public void test4(){
		synchronized(this){if(num <= 1){
			this.flag = false;
			return;
		}}
		try {
			Thread.sleep(50);//模拟延时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = num - 1;
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");
		
	}
	public synchronized void test2(){
		if(num <= 1){
			this.flag = false;
			return;
		}
		try {
			Thread.sleep(50);//模拟延时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = num - 1;
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");

	}
	
	
	public void test5(){
		synchronized((Integer)num){if(num <= 1){
			this.flag = false;
			return;
		}
		try {
			Thread.sleep(50);//模拟延时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = num - 1;
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");
		}
	}
	
	public void test6(){
		if(num <= 1){
			this.flag = false;
			return;
		}
		synchronized(this){
		try {
			Thread.sleep(50);//模拟延时
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		num = num - 1;
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");
		}
	}
}