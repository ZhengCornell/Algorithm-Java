package testannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

//使用反射读取注解的信息 模拟处理注解信息
public class Fanshe {
	public static void main(String args[]) throws NoSuchFieldException, SecurityException{
		try {
			//包含这个类全部信息的对象,却不是这个类的对象
			Class c = Class.forName("testannotation.SxtStudent");//包名＋类名
			//获得类的所有注解
			Annotation[] annotations = c.getAnnotations();
			Annotation k = c.getAnnotation(SxtTable.class);
			System.out.println(k);
			System.out.println(((SxtTable) k).value());
			
//			for(Annotation a:annotations){
//				System.out.println(a);
//				
//			}
			//获得类指定注解的值:从类中获得类注解
			SxtTable st = (SxtTable) c.getAnnotation(SxtTable.class);
			System.out.println(st);
			System.out.println(st.value());
			
			
			//获得类的属性的注解的值:1.先获得属性2.再从属性中获得属性注解
			Field f = c.getDeclaredField("id");
			Annotation fk = f.getAnnotation(SxtField.class);
//			SxtField sf = f.getAnnotation(SxtField.class);
//			System.out.println(sf.columnName()+sf.type()+sf.length());
			System.out.println(fk);
			System.out.println(((SxtField) fk).columnName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
