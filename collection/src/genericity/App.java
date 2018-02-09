package genericity;
//获取值，
//强制类型转换
//但是容易报错，需要手写
public class App {
	public static void main(String args[]){
//		Object obj = 50;
//		int score = (int) obj;//Object --- integer --- int 拆箱
//		System.out.println(score);
//		//存入整数，int－－－Integer－－－Object 多态
//		Student stu = new Student(70,"A");
//		int javaseScore = 0;
//		if(stu.getJavase() instanceof Integer){
//			javaseScore = (Integer)stu.getJavase();
//		}
//		System.out.println(javaseScore);
//		String oracleScore = "";
//		if(stu.getOracle() instanceof String){
//			oracleScore = (String)stu.getOracle();
//		}
//		System.out.println(oracleScore);
		Student stu = new Student();//建议加入泛型,否则擦除
		stu.setJavase("k");//这就是泛型擦除，创建对象stu没有加入泛型
		test(stu);//未指定类型，编译都懒得检查你
		System.out.println(stu.getJavase());
	
		Student<Object> stu2 = new Student<Object>();
//		test(stu2);//但是一旦指定类型，编译就会检查，看看这个方法你能不能用
	
	}
	 
	public static void test(Student<Integer> stu){
		//方法是Integer类
	}
}
