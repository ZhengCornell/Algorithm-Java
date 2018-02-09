package create;

public class ProgrammerApp {

	public static void main(String[] args) {
		//启动多线程 使用静态代理 Thread
//		1.创建真实角色
		Programmer p = new Programmer();
//		2.创建代理角色＋真实角色引用
		Thread proxy = new Thread(p);
//		3.调用start方法 代理角色启动
		proxy.start();
		for(int i = 0; i < 10; i++){
			System.out.println("我好");
		} 
	}

}
