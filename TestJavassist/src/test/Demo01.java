package test;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

//使用javassist生成新的类
public class Demo01 {

	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		//获得类池，池里造类
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("bean.Emp");
		//创建属性(直接写源码)
		CtField f1 = CtField.make("private int empno;",cc);
		CtField f2 = CtField.make("private String ename;",cc);
		cc.addField(f1);
		cc.addField(f2);
		//创建方法
		CtMethod m1 = CtNewMethod.make("public int getEmpno(){return empno;}",cc);
		CtMethod m2 = CtNewMethod.make("public void setEmpno(int empno){this.empno = empno;}",cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		//创建构造器
		CtConstructor con1 = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
		con1.setBody("{this.empno=empno;this.ename=ename;}");
		cc.addConstructor(con1);
		cc.writeFile("/Users/Gz/Desktop/testjava");//写进工作空间内
		System.out.println("success");
	}

}


