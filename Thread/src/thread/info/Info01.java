package thread.info;
//currentThread() 静态方法，在哪个线程中就代表哪个线程 Thread.currentThread()（当前线程）
//setName() getName()
//isAlive()
public class Info01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it = new MyThread();
		Thread proxy = new Thread(it);
//		proxy.setName("kk");
//		it.setName("111"); 报错了因为 实现 Runnable的没有setName 方法
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		proxy.start();
		System.out.println("启动后状态"+proxy.isAlive());
		Thread.sleep(10);
		it.stop();
		System.out.println("停止后状态"+proxy.isAlive());
		
		
		
		
	}
	
	
}
