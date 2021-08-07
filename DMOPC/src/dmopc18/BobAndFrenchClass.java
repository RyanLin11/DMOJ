package dmopc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BobAndFrenchClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[]a, b;
	static int[][]memo;
	public static void main(String[] args) throws IOException {
		n = readInt();
		a = new int[n];
		b = new int[n];
		memo = new int[n][3];
		for(int i = 0; i<n; i++) {
			a[i] = readInt();
		}
		for(int i = 0; i<n; i++) {
			b[i] = readInt();
		}
		System.out.println(f(0,2));
	}
	public static int f(int d, int x) {
		if(d>=n) return 0;
		if(memo[d][x]!=0) return memo[d][x];
		if(x==0) return memo[d][x] = f(d+1, 2)+b[d];
		return memo[d][x] = Math.max(f(d+1, x-1)+a[d], f(d+1, 2)+b[d]);
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
