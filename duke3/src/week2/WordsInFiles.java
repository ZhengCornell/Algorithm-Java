package week2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class WordsInFiles {
	private Map<String,ArrayList<String>> wordMap;
	public WordsInFiles(){
		wordMap = new HashMap<String,ArrayList<String>>();
	}
	private void addWordsFromFile(File f){
		FileResource fr = new FileResource(f);
		String fname = f.getName();
		for(String word:fr.words()){
			if(!wordMap.containsKey(word)){
				ArrayList<String> al = new ArrayList<String>();
				//这个单词存在的(key)
				//value是一个arraylist 装满了拥有这个单词的文件的名字
				al.add(fname);
				wordMap.put(word,al);
			}
			else{
				ArrayList<String> al = wordMap.get(word);
				if(!al.contains(fname)) al.add(fname);
			}
		}
	}
	public void buildWordFileMap(){
		wordMap.clear();
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			addWordsFromFile(f);
		}
	}
	
	public int maxNumber(){//可以找到出现在最多文件中的word是什么，出现在几个文件中
		int maxSize = 0;
		String maxWord;
		for(String key:wordMap.keySet()){
			int aSize = wordMap.get(key).size();//文件名数
			if(aSize > maxSize) {
				maxSize = aSize;
				maxWord = key;
			}
		}
		return maxSize;
	}
	
	public ArrayList<String> wordsInNumFiles(int number){
		int count =0;
		ArrayList<String> al = new ArrayList<String>();
		for(String key:wordMap.keySet()){//所有单词走一遍
			if(number == wordMap.get(key).size()){
				al.add(key);
				count++;
			}
		}
		System.out.println(count);
		return al;
	}
	
	public void printFilesIn(String word){
		System.out.println("Files containing "+word);
		for(String fname:wordMap.get(word)){
			System.out.println(fname);
		}
	}
	public void printAll(){
		for(String key:wordMap.keySet()){
			System.out.print(key+"\n");
			for(String fname:wordMap.get(key)){
				System.out.println(fname+",");
			}
			System.out.println();
		}
	}
	
	public void tester(){
		buildWordFileMap();
//		System.out.println("出现最多的单词出现在 "+maxNumber()+"个文件中");
		printFilesIn("tree");
//		printAll();
//		ArrayList<String> al = wordsInNumFiles(4);
//		for(String fname:al){
//			System.out.println(fname);
//		}
	}
	public static void main(String args[]){
		WordsInFiles wif = new WordsInFiles();
		wif.tester();
	}
	
	
	
	
	
	
	
	
}
