package ccc11;
import java.util.Scanner;
public class SumacSequences {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) { System.out.println(f(input.nextInt(), input.nextInt())+2);}
	public static int f(int a, int b) { return a<b? 0: f(b,a-b)+1;}
}