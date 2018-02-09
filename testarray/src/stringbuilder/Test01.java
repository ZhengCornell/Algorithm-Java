package stringbuilder;

public class Test01 {
	public static void main(String args[]){
		StringBuilder sb = new StringBuilder(); 
		StringBuilder sb1 = new StringBuilder(32); 
		StringBuilder sb2 = new StringBuilder("abcd");//字符数组长度初始为32，value[]＝; 
		sb2.append("EFG").append(321).append("随便");//return this 方法链
		System.out.println(sb2);
		StringBuilder sb6 = new StringBuilder("a");
		for(int i = 0; i < 1000; i++){
			sb6.append(i);
		}
		System.out.println(sb6);
	}
}
