package array;

public class TestString {
	public static void main(String args[]){
		char c[] = {'a', 'b','c','d'};
		String str = new String(c);
		String str2 = new String("abcd");
		System.out.println(str2.equals(str));
		System.out.println(str2 == str);
		System.out.println(str);
		
		String str3 = "def";
		String str4 = "def";
		System.out.println(str3.equals(str4));
		System.out.println("ABc".equalsIgnoreCase("abc"));
		
		"ABc".equalsIgnoreCase("abc");
		String gh = new String("a");
		for(int i = 0; i < 1000; i++){
			gh += i;
		}
		System.out.println(gh);
	}
}
