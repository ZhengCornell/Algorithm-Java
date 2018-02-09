package gen03;

import java.util.ArrayList;
import java.util.List;

public class ExtendsTest {
	public static void main(String args[]){
		//extends为上线 <=
		Test<Fruit> t1 = new Test<Fruit>();
		Test<Apple> t2 = new Test<Apple>();
		Test<Pear> t3 = new Test<Pear>();
		
//		Test<?> t = new Test<Apple>();
//		t = new Test<Pear>();
		//把创建的对象都给我包了
		List<? extends Fruit> l1 = new ArrayList<Fruit>();
		List<Fruit> l2 = new ArrayList<Fruit>();
		List<Apple> l3 = new ArrayList<Apple>();
		List<? extends Apple> l4 = new ArrayList<FujiApple>();
		//虽然右边看似合理，但左边声明中有一部分不符合test要求
		//虽然右边是Fruit，但是左边的问号等同于？extends Object,范围太大了
		List<?> l5 = new ArrayList<FujiApple>();
		List<FujiApple> app = new ArrayList<FujiApple>();
		test(l5);
	}
	public static void test(List<? extends Fruit> l){
//		Apple a = new Apple();
//		l.add(a);
		l.add(null);
		//失败了，因为该方法要保证向下兼容的一致性
		//需要保证0～fruit都可以用这个方法.
		//例如我要test（app），但是没办法把这个苹果对象塞进去
	}
	
	static class Test<T extends Fruit>{
		
	}
}
