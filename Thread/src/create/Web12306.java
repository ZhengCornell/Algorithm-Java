package create;
//方便共享方法
//1个12306，多个黄牛
public class Web12306 implements Runnable{
	private int num = 50;

	@Override
	public void run() {
	while(true){
		if(num <= 0){
			break;//跳出循环，线程结束
		}
		num = num - 1;
		System.out.println(Thread.currentThread().getName()+"抢到了第"+num+"张票");
	}
//	System.out.println("胜利者是"+Thread.currentThread().getName());
	}
	public static void main(String args[]){
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
