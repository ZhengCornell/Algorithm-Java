package princeton.day1;

public class ArrayStack {
	private String[] s;
	private int N = 0;
	private int size;
	public ArrayStack(int ca){
		s = new String[ca]; 
		this.size = ca;
	}
	public void push(String item){
		s[N] = item;
		N = N+1;
		if(N>size){
			
		}
	}
	public String pop(){
		String str = s[N-1];
		N = N - 1;
		s[N] = null;
		return str;
	}
	public boolean isEmpty(){
		return s[0] == null;
	}
	public String[] reSize(){
		String[] newstring = new String[this.size*2+1];
		for(int i = 0; i < this.size; i++){
			newstring[i] = s[i];
		}
		return newstring;
	}
}
