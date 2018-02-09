package week1;

import java.util.*;
public class LargestQuakes {
	public void findLargestQuakes(){
		EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
//        for(QuakeEntry qe:list){
//        	System.out.println(qe);
//        }
        System.out.println("# quakes read: " + list.size());
//        double maxMag = 0;
//        QuakeEntry maxMagQuake = null;
//        for(QuakeEntry qe:list){
//        	if(qe.getMagnitude() > maxMag){
//        		maxMagQuake = qe;
//        		maxMag = qe.getMagnitude();
//        	}
//        }
//        System.out.println(maxMagQuake);    
        ArrayList<QuakeEntry> listLargest = getLargest(list,5);
        for(QuakeEntry qe: listLargest){
        	System.out.println(qe);
        }
	}
	
	
	public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
		ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
		ArrayList<QuakeEntry> copy = quakeData;
		for(int j = 0; j < howMany; j++){
			int maxIndex = 0;
			for(int k = 1; k < copy.size(); k++){
				QuakeEntry qe = copy.get(k);
				if(qe.getMagnitude() > copy.get(maxIndex).getMagnitude()){
					maxIndex = k;
				}
			}
			answer.add(copy.get(maxIndex));
			copy.remove(maxIndex);
		}
		return answer;
	}
	
	
	
	public static void main(String args[]){
		LargestQuakes lq = new LargestQuakes();
		lq.findLargestQuakes();
	}
}
