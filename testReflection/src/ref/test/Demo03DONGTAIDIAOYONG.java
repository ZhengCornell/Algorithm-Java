package ref.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ref.been.User;

public class Demo03DONGTAIDIAOYONG {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		String path = "ref.been.User";
		Class<User> c = (Class<User>) Class.forName(path);
		//反射API调用构造方法  －－－－ 构造对象
		User u = c.newInstance();//调用了User类的无参构造方法(用整个镜子调用)，构造出对象
		System.out.println(u);
		Constructor<User> con = c.getDeclaredConstructor(int.class,int.class,String.class);
		User u2 = con.newInstance(1001,18,"gz");//用设定好的带参构造器调用，构造出对象
		System.out.println(u2.getAge());
		
		//通过反射API调用方法
		User u3 = c.newInstance();
//		u3.setName("gz");//这是直接调用
		Method m = c.getDeclaredMethod("setName",String.class);//方法激活
		m.invoke(u3,"nihao");
		System.out.println(u3.getName());
		
		//通过反射API操作属性,我希望注入数值
		User u4 = c.newInstance();
		Field f = c.getDeclaredField("age");
		f.set(u4,27);//若f是私有属性被调用，可以调用但不可以操作set
		Method m1 = c.getDeclaredMethod("setAge",int.class);
//		m1.invoke(u4,100);
		System.out.println(u4.getAge());
		
		Field f1 = c.getDeclaredField("id");
		f1.setAccessible(true);
		f1.set(u4,1001);//通过反射写属性，起点为镜子
		System.out.println(u4.getId());//调用对象 的方法
		System.out.println(f1.get(u4));//用反射，属性的镜子。get到u4的反射
	}

}
