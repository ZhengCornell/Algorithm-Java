package gen03;

import java.util.ArrayList;
import java.util.List;

//? 通配符，类型不确定，声明变量（包括了形参）
public class WildcardsTest {

	public static void main(String[] args) {
		List<?> l = new ArrayList<Integer>();
		l = new ArrayList<String>();
		l = new ArrayList<Object>();
		test(l);
	}
	
	public static void test(List<?> l){
		
	}
	
	class Test<T>{
		
	}

//	class Test2<?>{
//		
//	}

}
