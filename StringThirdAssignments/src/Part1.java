import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part1 {
	public static int findStopCodon(String dna, Integer startIndex, String stopCodon){
		if(startIndex == -1){
			return dna.length();
		}
		String subdna = dna.substring(startIndex);
		
		int stopIndex = -1;
//		stopIndex = subdna.indexOf(stopCodon);
//		if(stopIndex == -1){
//			return dna.length();
//		}
//		String subdna2 = subdna.substring(0,stopIndex+3);
//		if(subdna2.length() % 3 == 0){
//			return stopIndex;
//		}else{
//			return dna.length();
//		}
		while(stopIndex%3 != 0){
			stopIndex = subdna.indexOf(stopCodon,stopIndex+1);
			if(stopIndex == -1){
				return dna.length();
			}
			
		}
		return stopIndex;
		
		
	}
	
	
	
	public static Integer howMany(String stringa, String stringb){
		int count = 0;
		while(stringb != null){
			int startIndex = -1;
			startIndex = stringb.indexOf(stringa);
			if(startIndex == -1){
				return count;
			}
			count ++;
			stringb = stringb.substring(startIndex+stringa.length());
			if(startIndex+stringa.length()>stringb.length()){
				return count;
			}
		}
		return count;
	}
	public static void testFindStopCodon(){
		String d1 = "BEDATGEHFKEFCNDTAA";
		System.out.println(findStopCodon(d1,3,"TAA"));
		
	}
	public static void testFindGene(){
		String dna = "BEDATGEHFKEFCNDDDDTAA";
		findGene(dna);
	}
	public static List<String> printAllGenes(String dna){
		List<String> dnas = new ArrayList<String>();
		while(dna != ""){
			if(findGene(dna) != ""){
				String k = findGene(dna);
			dnas.add(k);
			
			}
			dna = children(dna);
			
		}
		return dnas;
	}
	public static String children(String dna){
		int startIndex = -1;
		int stopIndex = -1;
		startIndex = dna.indexOf("ATG");
		if(startIndex == -1){
			return "";
		}
		int taastop = findStopCodon(dna,startIndex,"TAA");
		int tagstop = findStopCodon(dna,startIndex,"TAG");
		int tgastop = findStopCodon(dna,startIndex,"TGA");
		int end = min(taastop,tagstop,tgastop);
		if(end == dna.length()){
			return "";
		}else{
			return dna.substring(end+startIndex+3);
		}
		
	}
	
	public static String findGene(String dna){//此处需要修改
		int startIndex = -1;
		int stopIndex = -1;
		startIndex = dna.indexOf("ATG");
		if(startIndex == -1){
			return "";
		}
		int taastop = findStopCodon(dna,startIndex,"TAA");
		int tagstop = findStopCodon(dna,startIndex,"TAG");
		int tgastop = findStopCodon(dna,startIndex,"TGA");
		int end = min(taastop,tagstop,tgastop);
		if(end == dna.length()){
			return "";
		}else{
			return dna.substring(startIndex,end+startIndex+3);
		}
		
	}
	private static int min(int a, int b, int c){
		if(a <= b){
			return min(a,c);
		}
		else{
			return min(b,c);
		}
	}
	private static int min(int a, int b){
		if(a <= b){
			return a;
		}
		return b;
	}
	
	public static StorageResource getAllGenes(String dna){
//		List<String> dnas = new ArrayList<String>();
		StorageResource store = new StorageResource();
		while(dna != ""){
			if(findGene(dna) != ""){
				String k = findGene(dna);
			store.add(k);
			
			}
			dna = children(dna);
			
		}
		return store;
	}
	
//	public static List<Double> cgRatio(String dna){
//		List<String> l = printAllGenes(dna);
//		List<Double> ld = new ArrayList<Double>();
//		for(int i = 0; i < l.size(); i++){
//			String temp = l.get(i);
//			Integer sum = howMany("C",temp)+ howMany("G",temp);
//			double ratio = (double) sum / temp.length();
//			ld.add(ratio);
//		}
//		return ld;
//	}
	public static double cgRatio(String dna){
		double ratio;
		
			Integer sum = howMany("C",dna)+ howMany("G",dna);
			ratio = (double)((double) sum / (double)dna.length());
			
		return ratio;
	}

	
//	public static void main(String[] args){
//		testFindStopCodon();
//		System.out.println(findGene("BEDATGEHFKEFCNDTAA"));
//		System.out.println(findGene("BEDATGEHFKEFCNDDDDTAA"));
//		File f = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/b");
//		FileResource fr = new FileResource(f);
//		String dna = fr.asString();
////		List<String> l = new ArrayList<String>();
////		l = printAllGenes(dna); //所有信息打成文件流fr
//////		processGenes(sr);
//		List<String> l = new ArrayList<String>();
//				l = printAllGenes(dna);
//		for(int i = 0; i < l.size(); i++){
//			System.out.println(l.get(i));
//			
//		}//分解DNA处有bug需要修复ATGATAABSTAA,这种情况我给失败，实际要成功
//	}


	public static void processGenes(StorageResource sr){
//		FileResource fr = new FileResource("/Users/Gz/Desktop/a");
//		String dna = fr.asString();
//		sr = getAllGenes(dna); //所有信息打成文件流fr
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		String longest = "";
		for(String item:sr.data()){
//			if(item.length()>9 && cgRatio(item) > 0.35){
//				num1++;
//				num2++;
//			}
//			else if(item.length()<=9 && cgRatio(item) > 0.35){
//				num2++;
//			}
//			else if(item.length()>9 && cgRatio(item) <= 0.35){
//				num1++;
//			}
//			
			if(longest.length()<item.length()){
				longest = item;
			}
			if(item.length()>60){
				num1++;
			}
			if(cgRatio(item)<0.35){
				num2++;
			}
			num3++;
		}
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(longest);
		
		
		
	}
	
	public static void main(String args[]){
		File f = new File("/Users/Gz/Desktop/eclipse/IOliu/src/io/file/b");
		FileResource fr = new FileResource(f);
		String dna = fr.asString();
		dna = dna.toUpperCase();
		StorageResource sr = new StorageResource();
		sr = getAllGenes(dna); //所有信息打成文件流fr
		processGenes(sr);
		
	}
//	最长，移除3  。 4，5个不对，需要重新测试1 2 3
	



}
