package thread.info;
//MAX_PRIORITY  10  概率优先级，并非绝对优先级，不是绝对先后顺序
//MIN_PRIORITY   1
//NORM_PRIORITY  5 
//setPriority(Thread.MAX_PRIORITY)
//getPriority()

public class Priority1 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it1 = new MyThread();
		Thread proxy1 = new Thread(it1,"一");
		MyThread it2= new MyThread();
		Thread proxy2 = new Thread(it2,"囖");
		proxy1.setPriority(Thread.MIN_PRIORITY);
		proxy2.setPriority(Thread.MAX_PRIORITY);
		proxy1.start();
		proxy2.start();
		Thread.sleep(100);
		it1.stop();
		it2.stop();
		

	}

}
