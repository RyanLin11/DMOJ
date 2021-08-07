package art2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prologue {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			char[]c = next().toCharArray();
			for(int j = 0; j<c.length; j++) {
				if(c[j]=='A'||c[j]=='a') {
					System.out.print("Hi! ");
				} else if(c[j]=='E'||c[j]=='e') {
					System.out.print("Bye! ");
				} else if(c[j]=='I'||c[j]=='i') {
					System.out.print("How are you? ");
				} else if(c[j]=='O'||c[j]=='o') {
					System.out.print("Follow me! ");
				} else if(c[j]=='U'||c[j]=='u') {
					System.out.print("Help! ");
				} else if(Character.isDigit(c[j])) {
					System.out.print("Yes! ");
				}
			}
			System.out.println();
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
