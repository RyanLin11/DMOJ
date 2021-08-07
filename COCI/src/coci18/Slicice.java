package coci18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Slicice {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, k;
	static int[]p,b;
	static long[][]dp;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		k = readInt();
		p = new int[n]; //the number of cards
		for(int i = 0; i<n; i++) {
			p[i] = readInt();
		}
		b = new int[m+1];
		for(int i = 0; i<m+1; i++) {
			b[i] = readInt();
		}
		dp = new long[n][k+1];
		System.out.println(f(0,k));
	}
	public static long f(int a, int k) {
		if(a>=n||k<0) return 0;
		if(dp[a][k]!=0) return dp[a][k];
		long max = 0;
		for(int i = 0; i<=Math.min(m-p[a],k); i++) {
			max = Math.max(max, b[p[a]+i]+f(a+1,k-i));
		}
		return dp[a][k] = max;
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
