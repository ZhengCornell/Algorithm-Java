package princeton.day1;

public class ResizingArrayStackOfStrings {
	private String[] s;
	private int N = 0;
	public ResizingArrayStackOfStrings(){
		s = new String[1];
	}
	public void push(String item){
		if(N == s.length){
			resize(2*s.length);
		}
		s[N] = item;
		N = N + 1;
	}
	public String pop(){
		String item = s[N - 1];
		N = N - 1;
		if(N > 0 && N == s.length/4){
			resize(s.length/2);
		}
		return item;
	}
	
	private void resize(int ca){
		String[] copy = new String[ca];
		for (int i = 0; i < N; i++){
			copy[i] = s[i];
		}
		s = copy;
	}
}
