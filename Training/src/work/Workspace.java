package work;
import java.util.Scanner;

public class Workspace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i<5; i++) {
			sum += in.nextInt();
		}
		System.out.println(sum);
	}

}
