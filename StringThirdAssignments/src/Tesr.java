
public class Tesr {
	public static void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
//	           System.out.println(index);
	           String found = input.substring(index+1, index+4);
	           System.out.println(found);
	           index = input.indexOf("abc",index+3);
	       }
	   }

	   public static void test(){
//	       findAbc("abcdabc");
	       findAbc("abcabcabcabca");
	   }
	   public static String mystery(String dna) {
		   int pos = dna.indexOf("T");
		   int count = 0;
		   int startPos = 0;
		   String newDna = "";
		   if (pos == -1) {
		     return dna;
		   }
		   while (count < 3) {
		     count += 1;
		     newDna = newDna + dna.substring(startPos,pos);
		     startPos = pos+1;
		     pos = dna.indexOf("T", startPos);
		     if (pos == -1) {
		       break;
		     }
		   }
		   newDna = newDna + dna.substring(startPos);
		   return newDna;
		 }
	   public static void main(String[] args){
		   String str = mystery("ABDUWJFTTTNTTTSJJW");
		   System.out.println(str);
	   }
	   
}
