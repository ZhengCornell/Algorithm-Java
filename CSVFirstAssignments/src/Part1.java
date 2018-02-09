import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class Part1 {
	public static void tester1(File src){
		
		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser();
		System.out.println(countryInfo(parser,"Nauru"));
//		listExportersTwoProducts(parser,"gold","diamonds");
//		int i = numberOfExporters(parser,"gold");
//		System.out.println(i);
	}
	public static void tester2(File src){

		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser();
		listExportersTwoProducts(parser,"cotton","flowers");
	}
	public static void tester3(File src){
		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser();
		int i = numberOfExporters(parser,"cocoa");
		System.out.println(i);
	}
	public static void tester4(File src){
		
		FileResource fr = new FileResource(src);
		CSVParser parser = fr.getCSVParser();
		bigExporters(parser,"$999,999,999,999");
	}
	public static void bigExporters(CSVParser parser,String dollars){
		for(CSVRecord record:parser){
			String d = record.get("Value (dollars)");
			if(d.length() > dollars.length() || (d.length() == dollars.length()&&(d.compareTo(dollars)>=0))){
				String str = record.get("Country") + " " + record.get("Value (dollars)");
				System.out.println(str);
			}
		}
	}
	
	public static String countryInfo(CSVParser parser, String country){
		for(CSVRecord record:parser){
			String export  = record.get("Country");
			if(export.equals(country)){
				String str;
//				System.out.println(record.get("Country")+record.get("Exports")+":");
//				System.out.println(record.get("Value (dollars)"));
				str = record.get("Country") + record.get("Exports") +":"+"\n"+ record.get("Value (dollars)");
				return str;
			}
		}
		return "NOT FOUND";
	}
	
	public static int numberOfExporters(CSVParser parser, String exportItem){
		int count = 0;
		for(CSVRecord record:parser){
			String export = record.get("Exports");
			if(export.contains(exportItem)){
				count++;
			}
		}
		return count;
	}
	
	public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
		for(CSVRecord record:parser){
			String e12 = record.get("Exports");
			if(e12.contains(exportItem1)&&e12.contains(exportItem2)){
				System.out.println(record.get("Country"));
			}
		}
	}

	
	
	public static void main(String args[]){
		File src = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/exportdata.csv");
//		tester1(src);
		tester2(src);
//		tester3(src);
//		tester4(src);
	}
	
}
