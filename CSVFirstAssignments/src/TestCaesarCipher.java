import edu.duke.FileResource;

public class TestCaesarCipher {
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
	public int[] countLetters (String msg) {
        int[] counts = new int[26];
        for (char c : msg.toCharArray()) {
            char cuc = Character.toUpperCase(c);
            if (Character.isAlphabetic(cuc)) counts[ALPHABET.indexOf(cuc)]++;
        }
           
        return counts;
    }
	 public int maxIndex(int[] vals) {
	        
	        int indOfMax = 0;
	        int maxSoFar = vals[0];
	        
	        for (int i=1;i<vals.length;i++){
	        
	            if (vals[i]>maxSoFar) {
	                maxSoFar = vals[i];
	                indOfMax = i;
	            }
	        }
	        
	        return indOfMax;
	    }
	 public void simpleTests(){
		 FileResource fr = new FileResource();
		 String input = fr.asString();
		 breakCaesarCipher(input);
//		 CaesarCipherFinal ccf = new CaesarCipherFinal(18);
//		 System.out.println(ccf.encrypt(input));
//		 System.out.println(ccf.decrypt(ccf.encrypt(input)));
	 }

	 public void breakCaesarCipher(String input){
		 int key = getKey(input);
	     CaesarCipherFinal ccf1 = new CaesarCipherFinal(key);
	     System.out.println(ccf1.decrypt(input));
	 }
	 public String breakCaesarCipher2(String input){
		 int key = getKey(input);
	     CaesarCipherFinal ccf1 = new CaesarCipherFinal(23);
	     return ccf1.decrypt(input);
	 }
	 public int getKey(String input){
	        int[] counts = countLetters(input);	  
	        int indOfMax = maxIndex(counts);	   
	        final int IND_E = 4;
	        int key = indOfMax - IND_E;
	        if (key<0) return key+26;
	        else return key;
	 }
	 public static void main(String args[]){
		 TestCaesarCipher cc = new  TestCaesarCipher();
		 cc.simpleTests();
	 }

	 

}
