package thread.syn;
//单例设计模式：确保一个类只有一个对象（类内部自己创建）
public class Syn02DANLI {

	public static void main(String[] args) {
		JvmThread thread = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		thread.start();
		thread2.start();
	}

}
class JvmThread extends Thread{//线程
	private long time;
	public JvmThread(){
		
	}
	public JvmThread(long time){
		this.time = time;
	}
	@Override
	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName()+"创建"+Jvm.getInstance(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

//目标：确保一个类只有一个对象
//懒汉式 double checking
//单例设计模式
//1.构造器私有化，避免外部直接创建对象
//2.声明一个私有的静态变量
//3.创建一个对外的公共静态方法访问该变量，如果变量没有对象，创建该对象

class Jvm{
	private static Jvm instance = null;
	
	//构造器私有化，避免外部直接创建对象
	private Jvm(){
		
	}
	
	public static Jvm getInstance(long time) throws InterruptedException{
		// a 已经创建了对象，bcde直接拿返回值就好了
		if(null == instance){
		//a  b 排队，a 出来有对象了， bcde全跟
		synchronized(Jvm.class){
		if(null == instance){
			Thread.sleep(time);
			instance = new Jvm();
		}
	}
	}
		return instance;
	}
	
	
	
	
	
	
	
//	public static Jvm getInstance(long time) throws InterruptedException{
//		不管有没有对象都需要等待
//		synchronized(Jvm.class){
//		if(null == instance){
//			Thread.sleep(time);
//			instance = new Jvm();
//		}
//		return instance;
//	}
//	}
	
	
	
	
//	public static synchronized Jvm getInstance(long time) throws InterruptedException{
//		if(null == instance){
//			Thread.sleep(time);
//			instance = new Jvm();
//		}
//		return instance;
//	}
}