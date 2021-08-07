package coci06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Ivana {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int[][]dp;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		arr = new int[n];
		dp = new int[n][n];
		for(int i = 0; i<dp.length; i++) Arrays.fill(dp[i], -1);
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			if(arr[i]%2-g((i-1+n)%n,(i+1)%n)>0) cnt++;
		}
		System.out.println(cnt);
	}
	public static int g(int a, int b) {
		if(a==b) return arr[a]%2;
		if(dp[a][b]!=-1) return dp[a][b];
		return dp[a][b] = Math.max(arr[a]%2-g((a-1+n)%n,b), arr[b]%2-g(a,(b+1)%n));
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
