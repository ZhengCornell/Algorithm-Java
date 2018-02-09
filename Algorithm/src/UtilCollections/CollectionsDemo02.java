package UtilCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo02 {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < 54; i++){
			l.add(i);
		}
		Collections.shuffle(l);
		//三个人玩牌
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<Integer>();
		for(int i = 0; i < 51; i+=3){
			p1.add(l.get(i));
			p2.add(l.get(i+1));
			p3.add(l.get(i+2));
		}
		last.add(l.get(51));
		last.add(l.get(52));
		last.add(l.get(53));
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(last);
	}


}
