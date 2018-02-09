package week3;

import java.util.ArrayList;

import edu.duke.FileResource;

public class Tester {
	public void testGetFollows(){
		MarkovOne markov = new MarkovOne();
		markov.setTraining("this is a test yes this is a test.");
		ArrayList<String> list = markov.getFollows("t");
		for(String s: list){
			System.out.print(s);
		}
		System.out.println(list.size());
	}
	
	public void testGetFollowsWithFile(){
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovModel markov = new MarkovModel(2);
		markov.setTraining(st);
		ArrayList<String> list = markov.getFollows("th");
		for(String s: list){
			System.out.print(s);
		}
		System.out.println(list.size());
	}
	
	
	
	
	public static void main(String args[]){
		Tester t = new Tester();
//		t.testGetFollows();
		t.testGetFollowsWithFile();
	}
}
