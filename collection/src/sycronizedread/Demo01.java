package sycronizedread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//使用Collections管理
//synchronizedList,Set,Map
public class Demo01 {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		List<String> synList = Collections.synchronizedList(l);
		System.out.println("OK");

	}

}
