package leee;

import java.util.Arrays;
import java.util.Scanner;

public class Meiju2 {
	public static void main(String args[]){
	Scanner input=new Scanner(System.in);
	int i[]= new int[4];
	int sign,count=0,j,k;
	double left, right;
	char oper[] = {' ','+','-','*','/'};
	int[] num = new int[5];
	for(j=0;j<=4;j++){
		num[j]=input.nextInt();
	}
	int res = input.nextInt();
	for(i[0] = 1;i[0] <= 4; i[0]++){
			if(i[0] < 4 || num[1] != 0 ){				
				for(i[1] = 1;i[1] <= 4; i[1]++){
					if(i[1] < 4 || num[2] != 0 ){				
						for(i[2] = 1;i[2] <= 4; i[2]++){
							if(i[2] < 4 || num[3] != 0 ){				
								for(i[3] = 1;i[3] <= 4; i[3]++){
									if(i[3] < 4 || num[4] != 0 ){				
										left = 0;
										right = num[0];
										sign = 1;
										for(k=0;k<=3;k++){
											switch(oper[i[k]]){
											case'+':
												left = left + sign*right;
												sign = 1;
												right = num[k+1];
												break;
											case'-':
	
												left = left - sign*right;
												
												right = num[k+1];
												break;
											case'*':
												right = right*num[k+1];
												break;
											case'/':
												right = right/num[k+1];
												break;
											}
											
										}
										if(left+sign*right==res){
											count++;
											
									
										}
										
									}
							}
							}
					}
					}
			}
			}
	}
	System.out.println(count);
	}	
}