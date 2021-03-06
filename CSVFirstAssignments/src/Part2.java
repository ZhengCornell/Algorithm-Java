import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
// String temp = row.get("TemperatureF");
//int value = Integer.parseInt(temp);	
public class Part2 {
	public static void testColdestHourInFile(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord coldest = coldestHourInFile(parser);
		System.out.println("coldest is at "/*+coldest.get("TimeEDT")*/+" "+coldest.get("TemperatureF"));
	}
	
	public static CSVRecord coldestHourInFile(CSVParser parser){
		CSVRecord coldestSoFar = null;
		
		for(CSVRecord currtRow:parser){
			if(coldestSoFar == null){
				coldestSoFar = currtRow;
			}
			else{
				double currtT = Double.parseDouble(currtRow.get("TemperatureF"));
				double coldestT = Double.parseDouble(coldestSoFar.get("TemperatureF"));
				if(currtT != -9999 && coldestT != -9999){
				if(currtT < coldestT){
					coldestSoFar = currtRow;
				}
				}
			}
		}
			return coldestSoFar;
	}	
	public static void testFileWithColdestTemperature(){
		File target = fileWithColdestTemperaturekkk();
		FileResource fr = new FileResource(target);
		System.out.println("Coldest day was in file "+target.getName());
		
		CSVParser parser = fr.getCSVParser();
		CSVRecord ccc = coldestHourInFile(parser);
		System.out.print("the day is " + ccc.get("DateUTC"));
		System.out.println("Coldest temperature on that day was "+ ccc.get("TemperatureF"));
		CSVParser ppp = fr.getCSVParser();
		for(CSVRecord record:ppp){
			System.out.println(record.get("DateUTC")+" "/*+coldest.get("TimeEDT")*/+" "+ record.get("TemperatureF"));
		}
	}
	
	
	public static File fileWithColdestTemperaturekkk(){
		File target = null;
		CSVRecord coldestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVRecord currtColdest = coldestHourInFile(fr.getCSVParser());
			if(coldestSoFar == null){
				coldestSoFar = currtColdest;
				target = f;
			}else{
				double currtT = Double.parseDouble(currtColdest.get("TemperatureF"));
				double coldestT = Double.parseDouble(coldestSoFar.get("TemperatureF"));
				if(currtT < coldestT){
					coldestSoFar = currtColdest;
					target = f;
				}
				
			}
			
		}
		return target;
	}
	public static CSVRecord fileWithColdestTemperature(){
		CSVRecord coldestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVRecord currtColdest = coldestHourInFile(fr.getCSVParser());
			if(coldestSoFar == null){
				coldestSoFar = currtColdest;
			}else{
				double currtT = Double.parseDouble(currtColdest.get("TemperatureF"));
				double coldestT = Double.parseDouble(coldestSoFar.get("TemperatureF"));
				if(currtT <= coldestT){
					coldestSoFar = currtColdest;
				}
				
			}
			
		}
		return coldestSoFar;
	}
	
	
	public static void testLowestHumidityInFile(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
	}
	
	public static double averageTemperatureInFile(CSVParser parser){
		double totalT = 0;
		int count = 0;
		for(CSVRecord record:parser){
			double currtT = Double.parseDouble(record.get("TemperatureF"));
			totalT += currtT;
			count++;
		}
		return (double)(totalT/(double)count);
	}
	
	public static void testaverageTemperatureInFile(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		System.out.println("Average temperature in file is " + averageTemperatureInFile(parser));
	}
	
	public static double averageTemperatureWithHighHumidityInFile(CSVParser parser, Integer value){
		double count = 0.0;
		double totalT = 0;
		for(CSVRecord currt:parser){
			double currtT = 0;
			String str = currt.get("Humidity");
			if(!str.equals("N/A")){
				Integer hum = Integer.parseInt(str);
				if(hum>=value){
					currtT = Double.parseDouble(currt.get("TemperatureF"));
					totalT += currtT;
					count += 1.0;
				}
			}
			
		}
		if(totalT == 0){
			return 0;
		}
		return (double)(totalT/(double)count);
	}
	public static void testAverageTemperatureWithHighHumidityInFile(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		System.out.println("Average temperature in file is " + averageTemperatureWithHighHumidityInFile(parser,80));
	}
	
	
	
	public static void testH(){
		File target = fileWithLowestHumiditykkk();
		FileResource fr = new FileResource(target);
		System.out.println("lowest day was in file "+target.getName());
		
		CSVParser parser = fr.getCSVParser();
		CSVRecord ccc = lowestHumidityInFile(parser);
		System.out.print("the day is " + ccc.get("DateUTC"));
		System.out.println("Lowestest humidity on that day was "+ ccc.get("Humidity"));
		CSVParser ppp = fr.getCSVParser();
		for(CSVRecord record:ppp){
			System.out.println(record.get("DateUTC")+" "/*+coldest.get("TimeEDT")*/+" "+ record.get("Humidity"));
		}
	}
	public static File fileWithLowestHumiditykkk(){
		File target = null;
		CSVRecord lowestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVRecord currtlowest = lowestHumidityInFile(fr.getCSVParser());
			if(lowestSoFar == null){
				lowestSoFar = currtlowest;
				target = f;
			}else{
					double currtHumidity = Double.parseDouble(currtlowest.get("Humidity"));
					double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
						if(currtHumidity < lowestHumidity){
							lowestSoFar = currtlowest;
							target = f;
						}
					}
				
			}
			
	
		return target;
	}
	public static CSVRecord lowestHumidityInFile(CSVParser parser){
		CSVRecord lowestH = null;
		for(CSVRecord currtH:parser){
			String str = currtH.get("Humidity");
			if(lowestH == null&& !str.equals("N/A") ){
				lowestH = currtH;
			}else{
				if(!currtH.get("Humidity").equals("N/A")&&!lowestH.get("Humidity").equals("N/A")){
				double currtHumidity = Double.parseDouble(currtH.get("Humidity"));
				double lowestHumidity = Double.parseDouble(lowestH.get("Humidity"));
					if(currtHumidity < lowestHumidity){
						lowestH = currtH;
					}
				}else{
					continue;
				}		
			}
		}
		return lowestH;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]){
//		testColdestHourInFile();
//		testFileWithColdestTemperature();
//		testLowestHumidityInFile();
//		testaverageTemperatureInFile();
//		testAverageTemperatureWithHighHumidityInFile();
		testH();
	}
}
