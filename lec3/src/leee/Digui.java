package leee;
/*递归*/
public class Digui {
	public static void main(String[] args){
	System.out.println(myM(6,2));
	}

	public static String myM(int n, int res){
		String a = "";
		String b = "0123456789abcdef"; 
		if(n == 0){
			return "";
		}
		else{
		a = myM(n / res, res);
		return a + b.charAt(n % res);
		}/*从后往前出货*/
	}
}