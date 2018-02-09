import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ggper {

	public static void main(String[] args) {
		List<String> str = new ArrayList<String>();
		ggrandom<String> i = new ggrandom<String>();
//		ggde<String> i = new ggde<String>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			str.add(item);
			i.enqueue(item);
		}
		for(String temp:str){
			StdOut.print(temp);
		}
	}

}
