package week2;

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry>{

	@Override
	public int compare(QuakeEntry q1, QuakeEntry q2) {
		String s1 = q1.getInfo();
		String s2 = q2.getInfo();
		if(s1.compareTo(s2) < 0){
			return -1;
		}else if(s1.compareTo(s2) > 0){
			return 1;
		}else if(q1.getDepth() < q2.getDepth()){
			return -1;
		}else if(q1.getDepth() > q2.getDepth()){
			return 1;
		}
		return 0;
	}

	
}
