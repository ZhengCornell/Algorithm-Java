package threadstatus;

public class Join extends Thread {

	
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println("join"+i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Join j = new Join();
		Thread t = new Thread(j);//新生
		t.start();//就绪
		//cpu调度后开始 运行
		for(int i = 0; i < 1000; i++){
			if(i == 50){
				t.join();//t 加入 把main 阻塞了
			}
			System.out.println("main"+i);
		}
	}

}
