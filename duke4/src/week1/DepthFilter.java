package week1;

import java.util.ArrayList;

public class DepthFilter implements Filter {
	private double min;
	private double max;
	public DepthFilter(double minDepth, double maxDepth){
		this.min = minDepth;
		this.max = maxDepth;
	}
	public boolean satisfies(QuakeEntry qe){
		return qe.getDepth() >= min && qe.getDepth() <= max;
	}
	
	public String getName() {
		return "DepthFilter";
	}
}
//class superFilter implements Filter{
//	非常不好
//}

class test{
	public static void main(String args[]){
		Filter df = new DepthFilter(-10000.0,-8000.0);
//		MinMagFilter mmf = new MinMagFilter(5.0);
		EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        ArrayList<QuakeEntry> listDepth = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe: list){
        	if(df.satisfies(qe)){
        		listDepth.add(qe);
        	}
        }
//        ArrayList<QuakeEntry> listMag = new ArrayList<QuakeEntry>();
//        for(QuakeEntry qe: list){
//        	if(mmf.satisfies(qe)){
//        		listMag.add(qe);
//        	}
//        }
	}
}