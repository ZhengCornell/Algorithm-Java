package week5;


public class WordGram {
    private String[] myWords;
    private int myHash;
    
    public int hashCode(){
    	return this.toString().hashCode();
    }
    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for(int k = 0; k < myWords.length; k++){
        	ret += myWords[k]+" ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(this.length() != other.length()){
        	return false;
        }
        for(int k = 0; k < myWords.length; k++){
        	if(!myWords[k].equals(other.wordAt(k))){
        		return false;
        	}
        }
        return true;

    }

    public WordGram shiftAdd(String word) {	
        
        int size = this.length();
        String[] dest = new String[size];
        for(int i = 1; i < size; i++){
        	dest[i - 1] = this.wordAt(i);
        }
        dest[size - 1] = word;
        WordGram out = new WordGram(dest, 0, myWords.length);
        return out;
    }
    
//    public void testShiftAdd(){
//    	String source = "this is a test this is a test this is a test of words";
////		String[] words = source.split("\\s+");
//		WordGram ans = shiftAdd(source);
//		System.out.println()
//    }
    
    public static void main(String args[]){
    	String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		WordGram wg = new WordGram(words,0,words.length);
		WordGram newwg = wg.shiftAdd("hehe");
		System.out.println(newwg);
    }
    
    public  void printWordGram(WordGram wg) {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i<wg.length();i++) {
            sb.append(wg.wordAt(i)).append(" ");
    }
    System.out.println(sb.toString());
    }

}