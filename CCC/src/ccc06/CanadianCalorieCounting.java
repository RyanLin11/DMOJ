package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CanadianCalorieCounting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt();
		int count = 0;
		switch(a) {
		case 1:
			count+=461;
			break;
		case 2:
			count+=431;
			break;
		case 3:
			count+=420;
			break;
		}
		int b = readInt();
		switch(b) {
		case 1:
			count+=100;
			break;
		case 2:
			count+=57;
			break;
		case 3:
			count+=70;
			break;
		}
		int c = readInt();
		switch(c) {
		case 1:
			count+=130;
			break;
		case 2:
			count+=160;
			break;
		case 3:
			count+=118;
			break;
		}
		int d = readInt();
		switch(d) {
		case 1:
			count+=167;
			break;
		case 2:
			count+=266;
			break;
		case 3:
			count+=75;
			break;
		}
		System.out.println("Your total Calorie count is "+count+".");
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
