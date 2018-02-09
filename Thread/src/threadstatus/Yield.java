package threadstatus;

public class Yield extends Thread{

	public static void main(String[] args) {
		Yield y = new Yield();
		Thread t = new Thread(y);//新生
		t.start();//就绪
		//cpu调度后开始 运行
		for(int i = 0; i < 1000; i++){
			if(i == 50){
				//写在谁的线程体里就暂停谁
				//看cpu调度掉不调
				//没有完全意义的暂停
				Thread.yield();
			}
			System.out.println("main"+i);
		}
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println("yield"+i);
		}
	}

}
