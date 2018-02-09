package week4;

import java.io.File;

import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class BabyNames {
	public static void printNames(){
		FileResource fr = new FileResource();
		for(CSVRecord rec:fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(rec.get(2));
			if(numBorn <= 7){
			System.out.println("Name "+rec.get(0)+" Gender "+rec.get(1)+" Num Born "+rec.get(2));
			}
			}
	}
	
	public static void totalBirths(){
		int totalBoyBirths = 0;
		int totalGirlBirths = 0;
		FileResource fr = new FileResource();
		for(CSVRecord rec:fr.getCSVParser(false)){
			int numBorn = Integer.parseInt(rec.get(2));
			if(rec.get(1).equals("F")){
			totalGirlBirths += numBorn;
			}else{
			totalBoyBirths += numBorn;
			}
			System.out.println(rec.get(0));
		}
		System.out.println("numBoy:"+totalBoyBirths+"\n"+"numGirl:"+totalGirlBirths);
	}
	// 以 Ethan M 2012 为例， 输出 为2 Emma F 输出为 2
	public static int getRank(String year, String name, String gender){
		int rank = 0;
		DirectoryResource dr = new DirectoryResource();
		CSVRecord prevRec = null;
		for(File f:dr.selectedFiles()){
			int index = -1;
			String path = f.getAbsolutePath();
			index = path.indexOf(year);
			if(index == -1) continue;
			FileResource fr = new FileResource(f);
			for(CSVRecord record:fr.getCSVParser(false)){
				if(record.get(1).equals(gender)){
					int num = Integer.parseInt(record.get(2));
					if(prevRec != null && num == Integer.parseInt(prevRec.get(2))){
						rank = rank;
					}else{
						rank = rank + 1;
					}
					if(record.get(0).equals(name)){
						return rank;
					}
					prevRec = record;
				}				
			}
		}
		return -1;
	}
	
	public static String getName(String year, Integer rank, String gender){
		int info = 0;
		DirectoryResource dr = new DirectoryResource();
		CSVRecord prevRec = null;
		for(File f:dr.selectedFiles()){
			int index = -1;
			String path = f.getAbsolutePath();
			index = path.indexOf(year);
			if(index == -1) continue;
			FileResource fr = new FileResource(f);
			for(CSVRecord record:fr.getCSVParser(false)){
				info = getRank(year,record.get(0),gender);
				if(info != rank){
					continue;
				}
				return record.get(0);
			}
		}
			return "NO NAME";
	}
	
	
	public static void main(String args[]){
//		printNames();
//		totalBirths();
//		System.out.println(getRank("2012","Ethan","F"));
		System.out.println(getName("2012",,"M"));
	}
}
