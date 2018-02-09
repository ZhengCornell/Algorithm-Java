package sort;

import java.util.Arrays;
import java.util.Date;

public class DateSort {

	public static void main(String[] args) {
		Date[] a = new Date[3];
		a[0] = new Date();
		a[1] = new Date(System.currentTimeMillis()-1000*3600);
		a[2] = new Date(System.currentTimeMillis()+1000*3600);
		boolean s = true;
		for(int j = 0; j < a.length; j++){
			for(int i = 0; i< a.length - 1 - j; i++){
				if(((Comparable)a[i]).compareTo(a[i+1]) > 0){
					Date temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] =temp;
					s = false;
				}
			}
			if(s){
				break;
			}
			
		}
		System.out.println(Arrays.toString(a));
	
	
	
	}

}
