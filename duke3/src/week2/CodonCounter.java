package week2;

import java.util.HashMap;
import java.util.Map;

import edu.duke.FileResource;

public class CodonCounter {
	private Map<String,Integer> codons;
	public CodonCounter(){
		codons = new HashMap<String,Integer>();
	}
	public void buildCodonMap(int start, String dna){
		codons.clear();
		for(int i = start; i < dna.length()-3; i += 3){
			String codon = dna.substring(i,i+3);
			if(!codons.containsKey(codon)){
				codons.put(codon,1);
			}else{
				codons.put(codon,codons.get(codon)+1);
			}
		}
	}
	
	public String getMostCommonCodon(){
		int maxCount = 0;
		String mostCodon = new String();
		for(String codon:codons.keySet()){
			int count = codons.get(codon);
			if(maxCount < count){
				maxCount = count;
				mostCodon = codon;
			}
		}
		String str = "Most common codon is "+mostCodon+"\t"+maxCount;
		return str;
	}
	
	public void printCodonCounts(int start, int end){
		for(String codon:codons.keySet()){
			int count = codons.get(codon);
			if(count >= start && count <= end){
				System.out.println(codon+"\t"+codons.get(codon));
			}		
		}
	}
	
	public int getCodonCount(){//计算codons的种类
		return codons.size();
	}
	
	public void tester(){
		
		FileResource fr = new FileResource();
		String dna = fr.asString();
		dna = dna.toUpperCase();
		buildCodonMap(0,dna);
		System.out.println(getMostCommonCodon());
		printCodonCounts(0,100);
		System.out.println("总数 "+getCodonCount());
	}
	public static void main(String args[]){
		CodonCounter cc = new CodonCounter();
		cc.tester();
	}
	
	
	
	
	
	
	
	
	
	
}
