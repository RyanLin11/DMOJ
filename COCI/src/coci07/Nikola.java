package coci07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nikola {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]fee;
	static int[][]memo;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		fee = new int[n];
		memo = new int[n+1][n+1];
		for(int i = 0; i<n; i++) {
			fee[i] = readInt();
		}
		System.out.println(f(1,1));
	}
	public static int f(int a, int j) {
		if(a<0||a>=fee.length) return Integer.MAX_VALUE/2;
		if(a==fee.length-1) return fee[a];
		if(j<fee.length+1 && memo[a][j]!=0) return memo[a][j];
		return memo[a][j] = Math.min(fee[a]+f(a-j, j), fee[a]+f(a+j+1, j+1));
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
