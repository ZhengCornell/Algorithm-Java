package princeton.day4;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCount {

	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
	ST<String,Integer> st = new ST<String,Integer>();
	while(!StdIn.isEmpty()){
		String word = StdIn.readLine();
		if(word.length() < minlen){
			continue;
		}
		if(!st.contains(word)){
			st.put(word,1);
		}
		else{
			st.put(word,st.get(word)+1);
		}
	}
	String max = "";
	st.put(max,0);
	for(String temp:st.keys()){
		if (st.get(temp) > st.get(max)){
			max = temp;
		}
	}
	StdOut.println(max + st.get(max));
	
	
	
	
	}

}
