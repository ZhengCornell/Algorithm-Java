import java.util.HashMap;
import java.util.Map;

import edu.duke.FileResource;

public class WordLengths {
	public static void countWordLengths(FileResource fr, int[] counts){
		Map<String,Integer> wordList = new HashMap<String,Integer>();
//		String[] wordList = new String[counts.length];
		int maxLength = 0;
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(String s:fr.words()){
			int wordLength = 0;
			for(int i = 0; i < s.length(); i++){
				char currtChar = s.charAt(i);
				int idx = alphabet.indexOf(Character.toLowerCase(currtChar));
				if(idx != -1){
				wordLength++;
				}
				
			}
			
			if(maxLength == 0){
				maxLength = wordLength;
			}else if (maxLength != 0 && maxLength<wordLength){
				maxLength = wordLength;
			}

			
			
			counts[wordLength] += 1;
			wordList.put(s,wordLength);
		
		}
		for(int j = 1; j < maxLength + 1; j++){
			System.out.print("长度为"+j+"的有");
			System.out.print(counts[j]+"个:");
			for(String temp:wordList.keySet()){
				if(wordList.get(temp)==j){
					System.out.print(temp+" ");
				}
			}
			System.out.println("");
		}
	}
	
	public static void main(String args[]){
		FileResource fr = new FileResource();
		countWordLengths(fr,new int[20]);
	}
}
