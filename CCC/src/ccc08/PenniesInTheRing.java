package ccc08;
import java.util.Scanner;
public class PenniesInTheRing {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0; n!=0; i++) {
			System.out.println(penny(n));
			n = input.nextInt();
		}
	}
	public static int penny(int r) {
		int count = 0;
		for(int i = 1; i<=r; i++) {
			count+=(int)Math.sqrt(Math.pow(r, 2)-Math.pow(i, 2));
		}
		count*=4;
		count+=4*r;
		count++;
		return count;
	}
}
