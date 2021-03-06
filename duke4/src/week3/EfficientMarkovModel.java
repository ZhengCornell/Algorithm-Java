package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel{
	private HashMap<String,ArrayList<String>> map;
	private int nOrder;
	
	public void buildMap(){
		String key;
		System.out.println("长度为"+myText.length());
		ArrayList<String> follows;
		for(int i = 0; i < myText.length()-nOrder+1;i++){
			key = myText.substring(i,i+nOrder);
			if(map.isEmpty()||!map.containsKey(key)){
				follows = new ArrayList<String>();
				int pos = 0;
				while(pos <= myText.length()){
					int start = myText.indexOf(key,pos);
					if(start == -1 || start + key.length() >= myText.length()){
						break;
					}
					String next = myText.substring(start+key.length(),start+key.length()+1);
					follows.add(next);
					pos = start + key.length();
				}
				map.put(key,follows);
			}
		}
	}
	public EfficientMarkovModel() {
		this(2);
	}
	
	public EfficientMarkovModel(int N){
		map = new HashMap<String,ArrayList<String>>();
		myRandom = new Random();
		this.nOrder = N;
	}
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
		buildMap();
		printHashMapInfo();
	}
	
	public ArrayList<String> getFollows(String key){
		ArrayList<String> mFollows = new ArrayList<String>();
		if(!map.containsKey(key)||map.get(key).size()==0){
			return mFollows;
		}
		return map.get(key);
	}
	
	private int biggestSize(HashMap<String,ArrayList<String>> map){
		int size = 0;
		if(map.size() != 0){
			for(String k:map.keySet()){
				for(int i = 0; i < map.get(k).size(); i++){
					if(map.get(k).size() > size){
						size = map.get(k).size();
					}
				}
			}
		}
		return size;
	}
	public void printHashMapInfo(){
		System.out.println("HashMap size is "+map.size());
		ArrayList<String> maxKey = new ArrayList<String>();
		int size = biggestSize(map);
		for(String k:map.keySet()){
			if(map.get(k).size() == size){
				maxKey.add(k);
			}
		}
		System.out.print("Max key is ");
		for(String k : maxKey){
			System.out.print("\""+k+"\""+",");
		}
		System.out.println(" max size is "+size);
	}
	public String getRandomText(int numChars){//创建一个和文本等长的字符串
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - nOrder);
		String key = myText.substring(index,index+nOrder);//从训练文章中随便找个key;
		//并以这个key为例创造了key后follows 的数组列表
		sb.append(key);
		for(int k=0; k < numChars - key.length(); k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0) break;
			//每次循环从数组中找一个后代,并换一个key
			String followsRandom = follows.get(myRandom.nextInt(follows.size()));
			sb.append(followsRandom);
			key = key.substring(1)+followsRandom;
		}
		
		return sb.toString();
	}
	public String toString(){
		return "EfficientMarkovModel of order "+nOrder;
	}
}
