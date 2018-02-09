import java.util.ArrayList;
import java.util.List;

public class Part3 {
	private static List<String> dnas = new ArrayList<String>();	
	
	public static int findStopCodon(String dna, Integer startIndex, String stopCodon){
		if(startIndex == -1){
			return dna.length();
		}
		String subdna = dna.substring(startIndex);
		int stopIndex = subdna.indexOf(stopCodon);
		if(stopIndex == -1){
			return dna.length();
		}
		String subdna2 = subdna.substring(0,stopIndex+3);
		if(subdna.length() % 3 == 0){
			return stopIndex;
		}else{
			return dna.length();
		}
		
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
//		List<String> dnas = new ArrayList<String>();
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
	
	public static String findGene(String dna){
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
	public static void main(String[] args){

		testFindStopCodon();
		System.out.println(findGene("AATGCTAACTAGCTGACTAAT"));
		System.out.println(findGene("BEDATGEHFKEFCNDDDDTAA"));
		List<String> l = new ArrayList<String>();
				l = printAllGenes("ATGTAAATGTAAATGMKLTAA");
		for(int i = 0; i < l.size(); i++){
			System.out.println(l.get(i));
			
		}
//		System.out.println(dnas.size());
		testCountGenes("ATGTAAATGTAAATGMKLTAA");
	}

	public static int countGenes(String dna){
		return dnas.size();
	}
	public static void testCountGenes(String dna){
		
		System.out.println(countGenes(dna));
	}


}
