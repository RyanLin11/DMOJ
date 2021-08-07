package ccc21sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecretInstructions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String prev = "";
		while(n != 99999) {
			int first2 = n / 1000;
			int last3 = n % 1000;
			int digit1 = first2 / 10;
			int digit2 = first2 % 10;
			int sumFirst2 = digit1 + digit2;
			if(sumFirst2 %2 == 1) {
				System.out.println("left "+last3);
				prev = "left ";
			} else if(sumFirst2 == 0) {
				System.out.println(prev+last3);
			} else {
				System.out.println("right "+last3);
				prev = "right ";
			}
			n = readInt();
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
