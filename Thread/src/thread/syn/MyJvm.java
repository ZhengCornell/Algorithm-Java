package thread.syn;
//单例创建的方式：确保一个类只有一个对象。
//1.懒汉式：构造器私有化，声明私有静态属性，对外提供访问属性的静态方法，确保该对象存在
public class MyJvm {
	private static MyJvm instance;
	private MyJvm(){
		
	}
	public static MyJvm getInstance(){
		if(null == instance){//为了提高效率
			synchronized(MyJvm.class){
			if(null == instance){//为了安全
				instance = new MyJvm();
			}
			}
		}		
		return instance;
	}
}

//2.饿汉式：构造器私有化，声明私有静态属性的同时创建该对象，对外提供访问属性的静态方法
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
	private MyJvm2(){
		
	}
	public static MyJvm2 getInstance(){
		return instance;
	}
}
//类在使用时加载 这个内部类延缓了加载时间，我若不使用这个类的方法，那么我的内部类不调用，意味着我也无需初始化属性
class MyJvm3 {
	private static class JVMholder{//内部类
	private static MyJvm3 instance = new MyJvm3();
	}
	private MyJvm3(){
		
	}
	public static MyJvm3 getInstance(){
		return JVMholder.instance;
	}
}