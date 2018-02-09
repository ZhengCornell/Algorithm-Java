package UtilCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections 是一个工具类
public class CollectionsDemo01 {
	public static void main(String args[]){
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println(l);
		Collections.reverse(l);
		System.out.println(l);
		Collections.shuffle(l);
		System.out.println(l);
	}
}
