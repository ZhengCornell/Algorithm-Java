
public class Part2 {
	public static Integer howMany(String stringa, String stringb){
		int count = 0;
		while(stringb != null){
			int startIndex = -1;
			startIndex = stringb.indexOf(stringa);
			if(startIndex == -1){
				return count;
			}
			count ++;
			stringb = stringb.substring(startIndex+stringa.length());
			if(startIndex+stringa.length()>stringb.length()){
				return count;
			}
		}
		return count;
	}
	
	public static void testHowMany(){
		String a = "acd";
		String b = "acacacacac";
		System.out.println(howMany(a,b));
	}
	public static void main(String[] args){
		testHowMany();
		
	}
	

}
