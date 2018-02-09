package gen03;

import java.util.ArrayList;
import java.util.List;

public class SuperTest {
	public static void main(String args[]){
		List<Apple> l1 = new ArrayList<Apple>();
		List<? super FujiApple> l3 = new ArrayList<Fruit>();
//		虽然右边看似合理，但左边声明中有一部分不符合test要求
		test(l3);
		List<Fruit> l2 = new ArrayList<Fruit>();
	}
	public static void test(List<? super Apple> l){
		//不能用于添加父类信息
		l.add(new Object());
		
	}
}
