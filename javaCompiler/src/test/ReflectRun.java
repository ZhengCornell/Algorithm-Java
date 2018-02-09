package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

//反射动态运行
public class ReflectRun {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, MalformedURLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		URL[] urls = new URL[]{new URL("file:///"+"Users/Gz/Desktop/testjava/")};
		URLClassLoader loader = new	URLClassLoader(urls);
		Class c = loader.loadClass("Hi");
		//调用main 方法
		Method m = c.getMethod("main",String[].class);
		m.invoke(null,(Object)new String[]{});//一定要强转Object,不然数组内字符串被拆分成多个字符串类参数

	}

}
