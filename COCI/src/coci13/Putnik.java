package coci13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Putnik {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]dp, arr;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		arr = new int[n][n];
		dp = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = readInt();
			}
		}
		System.out.println(f(0,0));
	}
	public static int f(int a, int b) {
		int n = Math.max(a, b);
		if(n==arr.length-1) return 0; 
		if(dp[a][b]!=0) return dp[a][b];
		return dp[a][b] = Math.min(arr[n+1][a]+f(n+1,b), arr[b][n+1]+f(a,n+1));
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
