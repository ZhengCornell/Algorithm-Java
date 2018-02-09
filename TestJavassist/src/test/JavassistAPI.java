package test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;

//测试API
public class JavassistAPI {

	public static void main(String[] args) throws Exception {
		test05();
	}

	public static void test01() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.Emp");//获得已有的类
		byte[] data = cc.toBytecode();
		System.out.println(Arrays.toString(data));//全是字节码的内容
		System.out.println(cc.getName());//获取类名
		System.out.println(cc.getSimpleName());//获得简要类名
		System.out.println(cc.getSuperclass().getName());//获得父类
		System.out.println(cc.getInterfaces());//获得接口
	}
	
	public static void test02() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.Emp");//获得已有的类
		
//		CtMethod m = CtNewMethod.make("public int add(int a, int b){return a+b;}",cc);
		CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);//决定这个方法公开私有保护……
		m.setBody("{System.out.println(\"新方法获得！\");return $1+$2;}");
		cc.addMethod(m);
		
		//如何通过反射调用新方法
		Class c = cc.toClass();
		Object obj = c.newInstance();//直接无参构造对象，用这个对象调用add新方法,obj就是一辆车
		Method method = c.getDeclaredMethod("add",int.class,int.class);
		Object result = method.invoke(obj,200,300);
		System.out.println(result);
	}
//修改已有方法的信息
	public static void test03() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.Emp");//获得已有的类
		
		CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
		cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
		cm.insertAt(8,"int b = 3;System.out.println(\"b = \"+b);");
		
		//还是在返回值之前
		//如何通过反射调用新方法
		Class c = cc.toClass();
		Object obj = c.newInstance();//直接无参构造对象，用这个对象调用add新方法,obj就是一辆车
		Method method = c.getDeclaredMethod("sayHello",int.class );
		Object result = method.invoke(obj,300);
		System.out.println(result);
	
	
	}

	public static void test04() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.Emp");//获得已有的类
		
		//创建新的属性
//		CtField f1 = CtField.make("private int empno;",cc);
		CtField f1 = new CtField(CtClass.intType,"salary",cc);
		f1.setModifiers(Modifier.PRIVATE);
		cc.addField(f1,"100");
		
		//获取声明的属性
		cc.getDeclaredField("ename");
//		cc.getDeclaredField("empno");
		//尝试加入setget方法
		cc.addMethod(CtNewMethod.getter("getSalary",f1));
		cc.addMethod(CtNewMethod.getter("setSalary",f1));
		//同理，可以通过反射调用
		
		
	}
//针对构造器
	public static void test05() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("test.Emp");//获得已有的类
		
		CtConstructor[] cs = cc.getDeclaredConstructors();
		for(CtConstructor c:cs){
			System.out.println(c.getLongName());
		}
	}




}
