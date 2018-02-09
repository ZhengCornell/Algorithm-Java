package gen03;
//富二代
//属性随所在位置定
//而方法的重写，随父类定
//方法新增随子类定


//父类为泛型类
public abstract class Father<T,T2> {
	T2 name;
	public abstract void test(T t);
}
//子类非泛型类
//子类声明时指定具体类型
//属性类型为具体类型
//方法中的类型也都为具体类型

class Child<A,B> extends Father<Integer,String>{
	A t2;

	@Override
	public void test(Integer t) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
	 
//子类为泛型类，类型在使用时确定
//泛型必须完全一致

class Child2<T1,T> extends Father<T,T1>{
	T1 t2;

	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
}

//子类为泛型类，父类不指定类型(泛型直接擦除)使用Object替换了
//父类中的name 从T 变成 了Object 子类中的n 仍然是T1
class Child3<T1,T> extends Father{
	T1 n;
	@Override
	public void test(Object t) {
		
	}
}

//同时擦除
class Child4 extends Father{
//	再也不能任意类型了
	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
	
}

//子类擦除，父类使用泛型(不存在)
 
