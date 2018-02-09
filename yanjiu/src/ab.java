
public class ab {

	public static void main(String[] args) {
		String text = "Hurray!!#! It's Friday! finally...";
		String[] words = text.split("!+");
		for(int i = 0; i< words.length; i++){
			System.out.println(words[i]);
		}
		
	}

}
