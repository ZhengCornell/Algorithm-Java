package algorithm;

public class Solution {
	
	    public int reverse(int x) {
	    int i = 0;
	    int m = 0;
	    int j;
	    while(x != 0){
	        j = x % 10;
	        m = (int) (m + j*(Math.pow(10,i)));
	        x = x / 10;
	        i++;
	    }
	        return m;
	    }
}

