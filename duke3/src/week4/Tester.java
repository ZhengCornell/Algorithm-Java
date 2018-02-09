package week4;

import edu.duke.FileResource;

public class Tester {
	private CaesarCipher cc;
	private CaesarCracker crack;
	private VigenereBreaker vb;
	
	private <T> void print(T t){
		System.out.println(t);
	}
	public Tester(int key){
		this.cc = new CaesarCipher(key);
		this.crack = new CaesarCracker();
		this.vb = new VigenereBreaker();
	}
	
	public void testCaesarCipher(){
		FileResource fr = new FileResource();
		String text = fr.asString();
		print("Before encrypt: ");
		print(text);
		print("After encrypt: ");
		print(cc.encrypt(text));
		
	}
	public void testCaesarCracker(){
		FileResource fr = new FileResource();
		String text = fr.asString();
		String encrypted = cc.encrypt(text);
		print("After encrypt: ");
		print(cc.encrypt(text));
		print("Cracked text: ");
		print(crack.decrypt(encrypted));
		print("Key found: ");
		print(crack.getKey(encrypted));
	}
	public void testVigenereCipher(String key){
		VigenereCipher stringvc = new VigenereCipher(key);
		int[] intkey = {17, 14, 12, 4};
		VigenereCipher intvc = new VigenereCipher(key);
		FileResource fr = new FileResource();
		String input = fr.asString();
		String intsencrypted = intvc.encrypt(input);
		String stringencrypted = stringvc.encrypt(input);
		
		print("Text to encrypt:");
		print(input);
		
		print("Encrypted with ints:");
		print(intsencrypted);
		
		print("Encrypted with string:");
		print(stringencrypted);
	}
	
	
	
	public static void main(String args[]){
		Tester t = new Tester(19);
//		t.testCaesarCipher();
//		t.testCaesarCracker();
		t.testVigenereCipher("rome");
	}
}
