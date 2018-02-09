package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {

	public static void main(String[] args) {
		Goods g = new Goods();
		List<Goods> l = new ArrayList<Goods>();
		l.add(new Goods(2000,100,"1"));
		l.add(new Goods(3000,500,"2"));
		l.add(new Goods(50040,1500,"3"));
		System.out.println(l);
		Collections.sort(l, new GoodsPriceComp());//提取自己设置的比较器
		
		System.out.println(l);

	}

}
