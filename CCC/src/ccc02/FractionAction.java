package ccc02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FractionAction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int d = readInt();
		int gcd = GCD(n,d);
		n/=gcd;
		d/=gcd;
		if(n%d==0) {
			System.out.println(n/d);
		}else if(n>d) {
			System.out.println(n/d+" "+n%d+"/"+d);
		} else {
			System.out.println(n+"/"+d);
		}
	}
	public static int GCD(int x, int y) {
		if(y==0) return x;
		return GCD(y, x%y);
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
