package week1;


import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    //这里有个过滤器， 返回所有大于这个震级的 地震信息
    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        //TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;              
    }
    
    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {      
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth){
    	ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    	for(QuakeEntry qe: quakeData){
    		if(qe.getDepth() < maxDepth && qe.getDepth() > minDepth){
    			answer.add(qe);
    		}
    	}
    	return answer;
    }
    public void quakesOfDepth(){
    	EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        ArrayList<QuakeEntry> listDeep = filterByDepth(list,-10000.0,-8000.0);
        for(QuakeEntry qe: listDeep){
        	System.out.println(qe);
        }
        System.out.println("Found "+listDeep.size()+" quakes that match that criteria");
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where){
    	ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    	for(QuakeEntry qe: quakeData){
    		if(qe.getInfo().contains(where)){
    			answer.add(qe);
    		}
    	}
    	return answer;
    }
    public void quakesByPhrase(){
    	EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        ArrayList<QuakeEntry> listPhrase = filterByPhrase(list,"Creek");
        for(QuakeEntry qe: listPhrase){
        	System.out.println(qe);
        }
        System.out.println("Found "+listPhrase.size()+" quakes that match that criteria");
    }
    
    
    

    
    
    
    
    
    
    public void dumpCSV(ArrayList<QuakeEntry> list){
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
	//找到最大的地震
	public void bigQuakes() {
	    EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedatasmall.atom.txt";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        
//        for (QuakeEntry qe : list) {
//            if (qe.getMagnitude() > 5.0) {
//                System.out.println(qe);
//            }
//        }
        Location jakarta  = new Location(-6.211, 106.845);
        ArrayList<QuakeEntry> listClose = filterByDistanceFrom(list,100000000,jakarta);
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listClose) {
           System.out.println(qe); 
        }
        System.out.println("Found "+listClose.size()+" quakes that match that criteria");
	}
	//这是所有的地震信息
    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
//        dumpCSV(list);
        for(QuakeEntry qe:list){
        	System.out.println(qe);
        }
        System.out.println("# quakes read: " + list.size());
    }
    
    public void closeToMe() {
        EarthQuakeParser parser = new EarthQuakeParser();
//        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom";
        String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        
        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }

    }
    public static void main(String[] args){

    	EarthQuakeClient eqc = new EarthQuakeClient();
//    	eqc.createCSV();
//    	eqc.bigQuakes();
//    	eqc.quakesOfDepth();
    	eqc.quakesByPhrase();
    }
}
