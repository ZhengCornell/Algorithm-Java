package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo04 {

	public static void main(String[] args) {
//		Date[] a = new Date[3];
//		a[0] = new Date();
//		a[1] = new Date(System.currentTimeMillis()-1000*3600);
//		a[2] = new Date(System.currentTimeMillis()+1000*3600);
//		SortMonitor.sort(a);
//		List<String> l = new ArrayList<String>();
//		l.add("a");
//		l.add("acm");
//		l.add("amc");
//		l.add("aaa");
//		SortMonitor.sort(l);
		
		String[] arr = {"a","abcd","abc","def"};
		SortMonitor.sort(arr, new StringComp());
		
	}

}
