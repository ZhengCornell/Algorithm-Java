package week4;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class gg2 {
	public static void printNames(){
		int count = 0;
		FileResource fr = new FileResource();
		for(CSVRecord rec:fr.getCSVParser(false)){
			if(rec.get(1).equals("M")){
			System.out.println("Name "+rec.get(0)+" Gender "+rec.get(1)+" Num Born "+rec.get(2));
			count ++;
			}
			}
		System.out.println(count);
	}
	public static void totalBirths(){
		int totalBoyBirths = 0;
		int totalGirlBirths = 0;
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord rec:parser){
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
	
	public static int getRank(int year,String name,String gender){
		String path = "/Users/Gz/Desktop/eclipse/duke2/us_babynames_by_year/";
		String filepath = path +"yob"+year+".csv";
		File src = new File(filepath);
		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser(false);
		int rank = 0;
		CSVRecord prevRec = null;
		for(CSVRecord record:fr.getCSVParser(false)){
			if(record.get(1).equals(gender)){
			rank++;
			if(record.get(0).equals(name)){
				return rank;
			}
		}
		}
		return -1;
	}
	
	public static String getName(int year, int rank, String gender){
		String path = "/Users/Gz/Desktop/eclipse/duke2/us_babynames_by_year/";
		String filepath = path +"yob"+year+".csv";
		File src = new File(filepath);
		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord record:parser){
			if (!record.get(1).equals(gender)) continue;
			if(rank == getRank(year,record.get(0),gender)) return record.get(0);
		}
		return "NO NAME";
	}
	
	public static String whatIsNameInYear(String name, int year, int newYear, String gender){
		int rank = getRank(year,name,gender);
		String newName = getName(newYear,rank,gender);
		String str = name +" born in "+ year +" would be "+newName+" if she was born in "+newYear;
		return str;
	}

	private static int findYear(String filepath){
		return Integer.parseInt(filepath.substring(3,7));
	}
	public static int yearOfHighestRank(String name, String gender){
		DirectoryResource dr = new DirectoryResource();
		int highestSoFar = -1;
		int yearOfRank = -1;
		String fileName;
		for(File f:dr.selectedFiles()){
			fileName = f.getName();
			int year = findYear(fileName);
			int rank = getRank(year,name,gender);
			if(rank == -1) continue;
			if(highestSoFar == -1){
				highestSoFar = rank;
				yearOfRank = year;
			}
			if(rank < highestSoFar){
				highestSoFar = rank;
				yearOfRank = year;
			}
		}
		return yearOfRank;
	}
	public static double getAverageRank(String name, String gender){
		double rankSum = 0.0;
		double rankCount = 0.0;
		String fileName;
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			fileName = f.getName();
			int year = findYear(fileName);
			int rank = getRank(year,name,gender);
			if(rank == -1) continue;
			rankSum += rank;
			rankCount += 1.0;
			
		}
		
		if(rankCount == 0.0) return -1.0;
		else return rankSum / rankCount;
	}
	
	public static int getToBirthsRankedHiger(int year, String name, String gender){
		int nameRank = getRank(year,name,gender);//3
		String path = "/Users/Gz/Desktop/eclipse/duke2/us_babynames_by_year/";
		String filepath = path +"yob"+year+".csv";
		File src = new File(filepath);
		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser(false);
		int totalBirths = 0;
		for(CSVRecord record:parser){
			if(!record.get(1).equals(gender)) continue;
			int recordNameRank = getRank(year,record.get(0),gender);
			if(recordNameRank < nameRank){
				totalBirths += Integer.parseInt(record.get(2));
			}
			else break;
		}
		return totalBirths;
	}
	
	public static void main(String agrs[]){
//		System.out.println(getRank(1971,"Frank","M"));
//		System.out.println(getName(1982,450,"M"));
//		System.out.println(whatIsNameInYear("Owen",1974,2014,"M"));
//		System.out.println(getAverageRank("Robert","M"));
		System.out.println(getToBirthsRankedHiger(1990,"Drew","M"));
//		printNames();
//		System.out.println(yearOfHighestRank("Mich","M"));
	}

}