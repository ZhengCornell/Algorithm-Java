package leee;

public class Nitui {
	public static void main(String args[]){
	int i;
	double n = 1000;
	for(i=48;i>=1;i--){
		n=n/(double)(1+0.0171/12.0);
	}
	System.out.println(n);
	}
}
