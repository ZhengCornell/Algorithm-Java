package gen03;
//与继承同理

public interface Shixian<T1,T2> {
	void test(T1 t);
}

class SX implements Shixian{

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
	//全部擦除
}

class SX1<T2> implements Shixian{

	@Override
	public void test(Object t) {
		// TODO Auto-generated method stub
		
	}
	//父类擦除 子类泛型
}
class SX2 implements Shixian<String,Integer>{

	@Override
	public void test(String t) {
		// TODO Auto-generated method stub
		
	}
	//子类擦除，父类精确
}
class SX3<T1,T3,T5,T2> implements Shixian<T1,T2>{

	@Override
	public void test(T1 t) {
		// TODO Auto-generated method stub
		
	}
	//子类父类都不擦，子类大于等于父类
}