package week3;


/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le.toString());
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2.toString());
    }
    
    public void testLogAnalyzer() {
    	 LogAnalyzer la = new LogAnalyzer();
    	 la.readFile();
//    	 la.printAll();
//    	 System.out.println("unique ip has "+la.countUniqueIPs());
//    	 la.printAllHigherThanNum(400);
//    	 ArrayList<String> a = la.uniqueIPVisitsOnDay("Sep 27");
//    	 System.out.println(a.size());
//    	 for(String temp:a){
//    		 System.out.println(temp);
//    	 }
//    	 System.out.println(a.size());
//    	 System.out.println(la.countUniqueIPsInRange(200,299));
    	 HashMap<String, Integer> counts = la.countVisitsPerIP();
//    	 ArrayList<String> zuiduofangwenip = la.iPsMostVisits(counts);
//    	 for(String temp: zuiduofangwenip){
//    		 System.out.println("最多访问ip是"+temp);
//    	 }
//    	 System.out.println(counts);
//    	 System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
    	 HashMap<String,ArrayList<String>> map = la.iPsForDays();
//    	 System.out.println(map);
    	 System.out.println(la.dayWithMostIPVisits(la.iPsForDays()));
    	 ArrayList<String> list = la.iPsWithMostVisitsOnDay(map,"Sep 30");
    	 for(String temp: list){
    		 System.out.println(temp);
    	 }
    }
    public static void main(String[] args){
    	Tester t = new Tester();
//    	t.testLogEntry();
    	t.testLogAnalyzer();
    }
}
