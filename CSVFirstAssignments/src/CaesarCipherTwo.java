
public class CaesarCipherTwo {
	 private CaesarCipherFinal cc0;
	 private CaesarCipherFinal cc1;

	public CaesarCipherTwo(int key0, int key1){
		cc0 = new CaesarCipherFinal(key0);
		cc1 = new CaesarCipherFinal(key1);
	}
	public String encrypt(String input) {
        
        StringBuilder sb = new StringBuilder(input);
        
        for (int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if (i%2==0) sb.setCharAt(i,cc0.encrypt(ch));
            else sb.setCharAt(i,cc1.encrypt(ch));
            
        }
        return sb.toString();
    }
	 public String decrypt(String input) {
	        String s0 = halfOfString(input, 0);
	        String s1 = halfOfString(input, 1);
	        
	        String de0 = cc0.decrypt(s0);
	        String de1 = cc1.decrypt(s1);
	        
	        return mix(de0, de1);
	    }
	  private static String halfOfString(String input, int start) {
	        
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i=start;i<input.length();i+=2) sb.append(input.charAt(i));
	        
	        return sb.toString();
	    
	    }
	  

	    private static String mix(String s0, String s1) {
	        
	        StringBuilder sb = new StringBuilder(s0+s1);
	        
	        //put s0 to place
	        for (int i=0;i<s0.length();i++) {
	            sb.setCharAt(2*i, s0.charAt(i));
	        }
	        //put s1 to place
	        for (int i=0;i<s1.length();i++) {
	            sb.setCharAt(2*i+1, s1.charAt(i));
	        }
	        return sb.toString();
	    
	    }
	    public static String breakCipher(String input) {
	        String s0 = halfOfString(input, 0);
	        String s1 = halfOfString(input, 1);
	        
	        String d0 = TestCaesarCipher.breakCaesarCipher2(s0);
	        String d1 = CaesarCipherFinal.breakCipher(s1);
	        
	        return mix(d0, d1);
	    
	    
	    }
}
