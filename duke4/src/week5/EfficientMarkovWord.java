package week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel{
	private String[] myText;
	private Random myRandom;
	private int myOrder;
	private HashMap<WordGram, ArrayList<String>> myMap;
	
	public EfficientMarkovWord(int order){
		myRandom = new Random();
		myOrder = order;
		myMap = new HashMap<WordGram, ArrayList<String>>();
//		printHashMapInfo();
	}
	
	public void setRandom(int seed){
		myRandom.setSeed(seed);
	}
	
	public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public int indexOf(String[] words, WordGram target, int start){
		for (int k = start; k < words.length - myOrder; k++){
			WordGram wg = new WordGram(words,k,myOrder);
			if(wg.equals(target)){
				return k;
			}
		}
		return -1;
	}

	public ArrayList<String> getFollows(WordGram kGram){
		buildMap(kGram);
		return myMap.get(kGram);
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
		
		WordGram key = new WordGram(myText, index, myOrder);
		//key.printWordGram(key);
		//String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-myOrder; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			WordGram k2 = key.shiftAdd(next);
			key = k2;
//			key.printWordGram(key);
		//	System.out.println("... " + sb.toString().trim());
		}
		
		return sb.toString().trim();
	}
	public String toString(){
		return "EfficientMarkovWord "+myOrder;
	}
	
	public void buildMap(WordGram kGram){
		if(!myMap.containsKey(kGram)){
			ArrayList<String> list = new ArrayList<String>();
			int pos = 0;
			while(pos < myText.length){
				int index = indexOf(myText,kGram,pos);
				if(index == -1 || index + kGram.length() > myText.length){
					break;
				}
				String next = myText[index + kGram.length()];
				list.add(next);
				pos = index + 1;
			}
			myMap.put(kGram, list);
		}
	}
	
	private int max(){
		int maxSize = 0;
		for(WordGram wg: myMap.keySet()){
			if(maxSize < myMap.get(wg).size()){
				maxSize = myMap.get(wg).size();
			}
		}
		return maxSize;
	}
	public void printHashMapInfo(){
		HashMap<WordGram,ArrayList<String>> ans = new HashMap<WordGram,ArrayList<String>>();
		for(WordGram wg: myMap.keySet()){
			if(max() == myMap.get(wg).size()){
				ans.put(wg, myMap.get(wg));
			}
		}	
		System.out.println("key number is "+ myMap.size());
		for(WordGram wg: ans.keySet()){
		System.out.print("largest keys is: "+"\""+wg+"\""+" value is: "+ans.get(wg).size()+" they are ");
		for(String temp: myMap.get(wg)){
			System.out.print("\""+temp+"\"");
		}
		System.out.println("");
		}
	}
	

	

}
