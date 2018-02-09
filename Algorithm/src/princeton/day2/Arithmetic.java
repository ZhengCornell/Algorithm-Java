package princeton.day2;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Arithmetic {

	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while(!StdIn.isEmpty()){
			String str = StdIn.readString();
			if(str.equals("(")){
			}
			else if(str.equals("+")){
				ops.push(str);
			}
			else if(str.equals("*")){
				ops.push(str);
			}
			else if(str.equals(")")){
				String op = ops.pop();
				if(op.equals("+")){
					vals.push(vals.pop()+vals.pop());
				}else if(op.equals("*")){
					vals.push(vals.pop()*vals.pop());
				}
			
			}
			else{
				vals.push(Double.parseDouble(str));
			}
		}
		StdOut.println(vals.pop());
	}

}
