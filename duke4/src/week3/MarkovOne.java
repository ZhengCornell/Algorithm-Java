package week3;

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne extends AbstractMarkovModel {
	
	
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	
	public String getRandomText(int numChars){//创建一个和文本等长的字符串
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - 1);
		String key = myText.substring(index,index+1);//从训练文章中随便找个key;
		//并以这个key为例创造了key后follows 的数组列表
		sb.append(key);
		for(int k=0; k < numChars - 1; k++){
			ArrayList<String> follows = getFollows(key);
			if(follows.size() == 0) break;
			//每次循环从数组中找一个后代,并换一个key
			String followsRandom = follows.get(myRandom.nextInt(follows.size()));
			sb.append(followsRandom);
			key = followsRandom;
		}
		
		return sb.toString();
	}
	public String toString(){
		return "MarkovOne of order 1";
	}
}
