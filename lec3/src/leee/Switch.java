package leee;
import java.util.Scanner;
public class Switch {
public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	
	int i = input.nextInt();
	switch(i){/*防止case穿透*/
		case 1:
			System.out.println("s");
			break;
		case 2:
			System.out.println("b");
			break;
		case 3:
			System.out.println("a");
			break;
		default:
			System.out.println("c");
	}
}

}
