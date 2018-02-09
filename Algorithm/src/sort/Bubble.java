package sort;

import java.util.Arrays;

public class Bubble {
	public static void main(String args[]){

		int[] arr = {2,9,3,8,7,6,5};
		arr = new int[]{1,7,4,2,3,4};
		
		
	}
	
	public static void end(int arr[]){
		boolean s = true;
		for(int j = 0; j < arr.length; j++){
			for(int i = 0; i< arr.length - 1 - j; i++){
				if(arr[i] > arr[i + 1]){
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] =temp;
					s = false;
				}
			}
			if(s){
				break;
			}
				
			
			
		}
	}
}
Integer
String
Character