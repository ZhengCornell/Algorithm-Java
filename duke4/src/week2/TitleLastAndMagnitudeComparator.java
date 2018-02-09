package week2;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {

	@Override
	public int compare(QuakeEntry q1, QuakeEntry q2) {
		String s1 = q1.getInfo();
		String s2 = q2.getInfo();
		String tl1 = s1.substring(s1.lastIndexOf(" ") + 1);
		String tl2 = s2.substring(s2.lastIndexOf(" ") + 1);
		int ans = tl1.compareTo(tl2);
		if(ans != 0){
			return ans;
		}else{
			return Double.compare(q1.getMagnitude(), q2.getMagnitude());
		}
	}
	
}
