package week2;

import java.util.ArrayList;
import java.util.List;

import edu.duke.FileResource;

public class WordFrequencies {
	private List<String> myWords;
	private List<Integer> myFreqs;
	public WordFrequencies(){
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}
	public void findUnique(){
		myWords.clear();
		myFreqs.clear();
		int count = 0;
		FileResource fr = new FileResource();
		for(String word:fr.words()){
			StringBuilder sb = new StringBuilder(word.length());
			word = word.toLowerCase();
//			for(int i = 0; i < word.length();i++){
//				char currtChar = word.charAt(i);
//				if(Character.isAlphabetic(currtChar)){
//					sb.append(currtChar);
//				}
//			}
//			word = sb.toString();
			int idx = myWords.indexOf(word);
			if(idx == -1){
			myWords.add(word);//相当于操作尾部
			myFreqs.add(1);
			count++;
			}else{
			int value = myFreqs.get(idx);
			myFreqs.set(idx,value+1);
			}
		}
		System.out.println(count);
				
	}
	public int findIndexOfMax(){
		int Max = 0;
		int idx = 0;
		for(int i = 0; i < myFreqs.size(); i++){
			if(Max == 0){
				Max = myFreqs.get(i);
			}else if (Max < myFreqs.get(i)){
				Max = myFreqs.get(i);
				idx = i;
			}
		}
		
		return idx;
	}
	
	
	public void tester(){
		findUnique();
		System.out.println("# Number of unique words: " +myWords.size());
		for(int k = 0; k < myWords.size();k++){
			System.out.println(myFreqs.get(k)+"--->"+myWords.get(k));
		}
		int idx = findIndexOfMax();
		System.out.println("The word that occurs most often and its count are: "+myWords.get(idx)+"\t"+myFreqs.get(idx));
	}
	public static void main(String args[]){
		WordFrequencies wf = new WordFrequencies();
		wf.tester();
	}
	
}
