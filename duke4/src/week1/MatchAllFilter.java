package week1;

import java.util.ArrayList;

public class MatchAllFilter implements Filter{
	private ArrayList<Filter> fs;
	private StringBuilder append;
	public MatchAllFilter(){
		fs = new ArrayList<Filter>();
		
	}
	public void addFilter(Filter f){
		fs.add(f);
	}
	
	
	@Override
	public boolean satisfies(QuakeEntry qe) {
		for(Filter currtF: fs){
			if(!currtF.satisfies(qe)){
				return false;
			}
		}
		return true;
	}
//	public String getName(){
//		return "";
//	}
	public String getName(){
		StringBuilder sb = new StringBuilder();
		for(Filter tempf: fs){
			String s = tempf.getName();
			sb = sb.append(s + " ");
		}
		String str = sb.toString();
		
		return str;
	}

}
