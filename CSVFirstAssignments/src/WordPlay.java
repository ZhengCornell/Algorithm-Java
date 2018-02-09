
public class WordPlay {
	public static String encrypt1(String input, int key){
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
		String alphabet1 = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabet1 = alphabet1.substring(key) + alphabet.substring(0,key);
		
		for(int i = 0; i < encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			int idx = alphabet.indexOf(currChar);
			int idx1 = alphabet1.indexOf(currChar);
			if(idx == -1 && idx1 == -1){
			continue;
			}
			if(idx != -1 && idx1 == -1){
				char newChar = shiftedAlphabet.charAt(idx);
				encrypted.setCharAt(i,newChar);
			}
			if(idx == -1 && idx1 != -1){
				char newChar = shiftedAlphabet1.charAt(idx1);
				encrypted.setCharAt(i,newChar);
			}
		}
		return encrypted.toString();
	
	}
	public static String encrypt2(String input, int key){
		boolean isLow = false;
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
		
		
		for(int i = 0; i < encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			if(Character.isLowerCase(currChar)){
				currChar = Character.toUpperCase(currChar);
				isLow = true;
			}
			int idx = alphabet.indexOf(currChar);
			char newChar = shiftedAlphabet.charAt(idx);
			if(isLow){
				newChar = Character.toLowerCase(newChar);
			}
			encrypted.setCharAt(i,newChar);
		}
		return encrypted.toString();
	
	}
	public static boolean isVowel(char ch){
		String alphabet = "aeiouAEIOU";
		int idx = alphabet.indexOf(ch);
		if(idx != -1){
			return true;
		}
		return false;
	}
	public static String replaceVowels(String phrase, char ch){
		StringBuilder str = new StringBuilder(phrase);
		for(int i = 0; i< str.length(); i++){
			char currtChar = str.charAt(i);
			if(isVowel(currtChar)){
				char newChar = ch;
				str.setCharAt(i,newChar); 
			}
			
		}
		return str.toString();
	}
	public static String emphasize(String phrase, char ch){
		StringBuilder str = new StringBuilder(phrase);
		char ch1 = Character.toUpperCase(ch);
		for(int i = 0; i< str.length(); i++){
			char currtChar = str.charAt(i);
			Character C = new Character(currtChar);
			if(C.equals(new Character(ch))||C.equals(new Character(ch1))){
				int idx = phrase.indexOf(currtChar);
				if(idx != -1 && i % 2 == 0){
					char newChar = '*';
					str.setCharAt(i,newChar);
				}else if(idx != -1 && i % 2 != 0){
					char newChar = '+';
					str.setCharAt(i,newChar);
				}
			}
			
		}
		return str.toString();
	}
	
	
	public static void main(String args[]){
		System.out.println(encrypt1("HelloWorld",3));
		System.out.println(encrypt2("HelloWorld",3));
		System.out.println(isVowel('a'));
		System.out.println(replaceVowels("HelloWorld",'^'));
		System.out.println(emphasize("Mary Bella Abracadabra",'a'));
	}
}
