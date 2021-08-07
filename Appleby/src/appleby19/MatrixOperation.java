package appleby19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixOperation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]arr, dp;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		arr = new int[n][n];
		dp = new int[n][n];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				arr[i][j] = readInt();
			}
		}
		int max = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				max = Math.max(max, f(i,j));
			}
		}
		System.out.println(max);
	}
	public static int f(int r, int c) {
		int max = 0;
		if(dp[r][c]!=0) return dp[r][c];
		if(r-1>=0 && arr[r-1][c]<arr[r][c]) max = Math.max(max, 1+f(r-1,c));
		if(r+1<n && arr[r+1][c]<arr[r][c]) max = Math.max(max,1+f(r+1,c));
		if(c-1>=0 && arr[r][c-1]<arr[r][c]) max = Math.max(max, 1+f(r,c-1));
		if(c+1<n && arr[r][c+1]<arr[r][c]) max = Math.max(max, 1+f(r,c+1));
		return dp[r][c] = max;
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
