package week2;


/**
 * Write a description of class DifferentSorters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class DifferentSorters {
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/earthQuakeDataDec6sample1.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        int quakeNum = 50;
        System.out.println("Print quake entry in position "+quakeNum);
        System.out.println(list.get(quakeNum));

    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        int quakeNum = 10;
        System.out.println("Print quake entry in position "+quakeNum);
        System.out.println(list.get(quakeNum));

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/nov20quakedata.atom.txt";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
   
    public void sortByTitleAndDepth(){
    	EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/earthQuakeDataDec6sample1.atom.txt";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleAndDepthComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        int quakeNum = 50;
        System.out.println("Print quake entry in position "+quakeNum);
        System.out.println(list.get(quakeNum));
    }
    public void sortByLastWordInTitleThenByMagnitude(){
    	EarthQuakeParser parser = new EarthQuakeParser();
        String source = "/Users/Gz/Desktop/eclipse/duke4/earthQuakeDataDec6sample2.atom.txt";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
        int quakeNum = 50;
        System.out.println("Print quake entry in position "+quakeNum);
        System.out.println(list.get(quakeNum));
    }
    
    
    
    public static void main(String args[]){
    	DifferentSorters ds = new DifferentSorters();
//    	ds.sortWithCompareTo();
//    	ds.sortByTitleAndDepth();
    	ds.sortByLastWordInTitleThenByMagnitude();
    }
}
