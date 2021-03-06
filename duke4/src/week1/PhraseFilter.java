package week1;

public class PhraseFilter implements Filter {
	private String request;
	private	String phrase;
	public PhraseFilter(String request, String phrase){
		this.request = request;
		this.phrase = phrase;
	}
	
	
	
	
	
	
	@Override
	public boolean satisfies(QuakeEntry qe) {
		String title = qe.getInfo();
		if(request.equals("end")) return title.endsWith(phrase);
		if(request.equals("start")) return title.startsWith(phrase);
		if(request.equals("any")) return title.contains(phrase);
		return false;
	}






	public String getName() {
		return "PhraseFilter";
	}
	
}
