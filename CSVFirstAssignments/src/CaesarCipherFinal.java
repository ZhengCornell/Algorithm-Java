
public class CaesarCipherFinal {
	private final String ALPHABET;
	private final String SHIFTEDALPHABET;
	private final int KEY;
	public CaesarCipherFinal(int key){
		ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		SHIFTEDALPHABET = ALPHABET.substring(key)+ALPHABET.substring(0,key);
		KEY = key;
	}
	public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        for (int i=0; i< sb.length(); i++) {
            char encrypted = encrypt(sb.charAt(i));
            sb.setCharAt(i, encrypted);
        }  
        return sb.toString();
	}
	
	public char encrypt(char ch) {       
        char chUC = Character.toUpperCase(ch);
        int cInd = ALPHABET.indexOf(chUC);
        if (cInd==-1) return ch;
        int enInd = (cInd+KEY)%26;
        char enCh = ALPHABET.charAt(enInd);
        if (Character.isUpperCase(ch)) return enCh;
        else return Character.toLowerCase(enCh);
    }
	public String decrypt(String input){
		CaesarCipherFinal cc = new CaesarCipherFinal(26-KEY);
		return cc.encrypt(input);
	}
//	public String decrypt(String input){
//		 StringBuilder sb = new StringBuilder(input);
//	        
//	        for (int i=0; i< sb.length(); i++) {
//	            char decrypted = decrypt(sb.charAt(i));
//	            sb.setCharAt(i, decrypted);
//	        }
//	        
//	        return sb.toString();	
//	}
//	private char decrypt(char ch){
//		char chUC = Character.toUpperCase(ch);
//        int cind = ALPHABET.indexOf(chUC);
//        if (cind == -1) return ch;
//        int dind = (cind - KEY) % 26;
//        if (dind <0) dind+=26;
//        char dch = ALPHABET.charAt(dind);
//        if (Character.isUpperCase(ch)) return dch;
//        else return Character.toLowerCase(dch);
//	}
	public static void main(String args[]){
		CaesarCipherFinal ccf1 = new CaesarCipherFinal(23);
		CaesarCipherFinal ccf2 = new CaesarCipherFinal(17);
		System.out.println(ccf1.encrypt("First Legion"));
		System.out.println(ccf1.decrypt("Cfopq Ibdflk"));
		System.out.println(ccf2.encrypt("First Legion"));
		System.out.println(ccf2.decrypt("Wzijk Cvxzfe"));
	}
}
