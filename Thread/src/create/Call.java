package create;
//好处 可以返回值，可以throw 异常
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Call {
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		//创建一个线程
		ExecutorService ser = Executors.newFixedThreadPool(2);
		Race tortoise = new Race("千年王八",1000);
		Race rabbit = new Race("兔子",500);
		//获取值
		Future<Integer> result1 = ser.submit(tortoise);
		Future<Integer> result2 = ser.submit(rabbit);
		
		Thread.sleep(2000);//线程延迟2秒，停止循环
		tortoise.setFlag(false);
		rabbit.setFlag(false);
		int num1 = result1.get();
		int num2 = result2.get();
		System.out.println("乌龟跑了"+num1+"兔子跑了"+num2);
		//停止服务
		ser.shutdownNow();
	}
}
class Race implements Callable<Integer>{
	private String name;
	private long time;
	private boolean flag = true;
	private int step = 0;//步伐循环一次＋一次
	
	public Race() {
		
	}
	public Race(String name) {
		super();
		this.name = name;
	}
	public Race(String name, long time) {
		super();
		this.name = name;
		this.time = time;
	}


	@Override
	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(time);//延迟
			step++;
		}
		return step;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
}