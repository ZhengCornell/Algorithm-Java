package ref.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//利用反射API获取类的更多信息（类的名字，属性，方法，构造器）
public class Demo02 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		String path = "ref.been.User";
		Class c = Class.forName(path);
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		//获取属性
		Field[] fs = c.getFields();//这个方法只能获取一系列的public 的 属性
		Field[] fs1 = c.getDeclaredFields();//获取所有无论public or private 属性
		Field f = c.getDeclaredField("id");
		System.out.println(f);
		System.out.println(fs1.length);
		System.out.println(fs.length);
		for(Field temp:fs){
			System.out.println("属性为"+temp);
		}
		//获取方法
		Method[] ms = c.getDeclaredMethods();
		Method m01 = c.getDeclaredMethod("setName",String.class);//传递参数类型，防止重载意外
		Method m02 = c.getDeclaredMethod("setName",Integer.class);
//		System.out.println(ms.length);
		for(Method temp:ms){
			System.out.println("方法为"+temp);
		}
		
		//获取构造器方法
		Constructor[] cons = c.getDeclaredConstructors();
		Constructor con = c.getDeclaredConstructor(int.class,int.class,String.class);
		System.out.println("构造器为"+con);
		for(Constructor temp:cons){
			System.out.println("构造器为"+temp);
		}
	
	
	}

}
