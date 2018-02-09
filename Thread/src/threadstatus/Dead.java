package threadstatus;

public class Dead {
	public static void main(String args[]){
		Study s = new Study();
		new Thread(s).start();//直接匿名调用
		for(int i = 0; i < 100; i++){
			if(50==i){
				s.stop();
			}
			System.out.println("main" + i);
		}
	}
}

class Study implements Runnable{
	//定义一个标识，供线程体使用，
	//提供对外方法可以让外界改变，例如set
	private boolean flag = true;
	@Override
	public void run() {
		while(flag){
			System.out.println("运行");
		}
		
	} 
	public void stop(){
		this.flag = false;
	}
	
	
	
}