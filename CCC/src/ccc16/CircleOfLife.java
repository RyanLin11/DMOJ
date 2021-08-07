package ccc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CircleOfLife {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int[][]dp;
	public static void main(String[] args) throws IOException {
		int N = readInt(); long T = readLong();
		char[]c = next().toCharArray();
		arr = new int[N];
		dp = new int[N][64];
		for(int i = 0; i<dp.length; i++) {
			for(int j = 0; j<dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}
		for(int i = 0; i<N; i++) {
			arr[i] = c[i] - 48;
		}
		for(int i = 0; i<N; i++) {
			System.out.print(f(i, T));
		}
		System.out.println();
	}
	public static int f(long x, long t) {
		int n = (int)(((x%arr.length)+arr.length)%arr.length);
		int m = Long.numberOfLeadingZeros(t);
		if(t == 0) return arr[n];
		long lsb = Long.highestOneBit(t);
		if(dp[n][m] >= 0) return dp[n][m];
		return dp[n][m] = f(x-lsb, t - lsb) ^ f(x + lsb, t - lsb);
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
