import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Learning {
	public static void countShakespeare(){
		String[] common = getCommon();
		int[] counts = new int[common.length];
		DirectoryResource dr = new DirectoryResource();
		for(File f:dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			countWords(fr,common,counts);
			System.out.println("done with" + f.getName());	
		}
//		String[] plays = {"caesar.txt","errors.txt","hamlet.txt",
//				"likeit.txt","macbeth.txt","romeo.txt"};
//		for(int k = 0; k < plays.length; k++){
//			FileResource fr = new FileResource("data/"+plays[k]);
//			countWords(fr,common,counts);
//			System.out.println("done with" + plays[k]);
//		}
		for(int j = 0; j < common.length; j++){
			System.out.println(common[j] +"\t"+counts[j]);
		}
	}
	
	public static String[] getCommon(){
		FileResource fr = new FileResource("/Users/Gz/Desktop/eclipse/CSVFirstAssignments/common.txt");
		String[] common = new String[20];
		int idx = 0;
		for(String s:fr.words()){
			common[idx] = s;
			idx++;
		}
		return common;
	}
	public static int indexOf(String[] list, String word){//输出这个单词在第几个，为了counts[]准备
		for(int k = 0; k < list.length; k++){
			if(list[k].equals(word)){
				return k;
			}
		}
		return -1;
	}
	public static void countWords(FileResource fr, String[] common, int[] counts){
		for(String word:fr.words()){
			word = word.toLowerCase();
			int idx = indexOf(common,word);
			if(idx != -1){
				counts[idx] += 1;
			}
		}
	}
	
	public static void main(String args[]){
		countShakespeare();
	}
	
}
