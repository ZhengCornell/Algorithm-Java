package iterator;

import java.util.StringTokenizer;
//实现Enumeration
//StringTokenizer 是 Enumeration 子类，类似String.split()
//不支持正则表达式
//StringTokenizer(String str, String delim)
public class StringTokenizerDemo01 {
	public static void main(String args[]){
		String s = "i am your dad and you are my son";
		StringTokenizer t = new StringTokenizer(s," ");
		while(t.hasMoreElements()){
			System.out.println(t.nextElement());
		}
	}
}
