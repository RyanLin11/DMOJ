package ccc15;
import java.util.Scanner;
public class SpecialDay {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int d = input.nextInt();
		if(m<2) {
			System.out.println("Before");
		} else if(m==2) {
			if(d<18) System.out.println("Before");
			else if(d==18) System.out.println("Special");
			else System.out.println("After");
		} else {
			System.out.println("After");
		}
	}
}