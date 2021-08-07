package ccc11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhoHasSeenTheWind {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int h = readInt();
		int m = readInt();
		for(int t = 1; t<=m; t++) {
			if(-6*Math.pow(t, 4)+h*Math.pow(t, 3)+2*Math.pow(t, 2)+t<=0) {
				System.out.println("The balloon first touches ground at hour:");
				System.out.println(t);
				return;
			}
		}
		System.out.println("The balloon does not touch ground in the given time.");
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
