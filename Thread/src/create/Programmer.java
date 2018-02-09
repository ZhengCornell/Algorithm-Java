package create;
//尝试用runnable 创建线程
//1.类实现 runnable 接口＋重写run方法
//1.真实角色 programmer
//启动多线程 使用静态代理 Thread
//	1.创建真实角色
//	2.创建代理角色＋真实角色引用
//	3.调用start方法
public class  Programmer implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println("你好");
		}
		
	}

}
