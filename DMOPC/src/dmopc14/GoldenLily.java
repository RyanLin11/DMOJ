package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoldenLily {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), n = readInt();
		int[][]dp = new int[n][m];
		int[][]arr = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				arr[i][j] = readInt();
			}
		}
		int c = readInt(), r = readInt(); dp[0][0] = arr[0][0];
		for(int i = 1; i<m; i++) dp[0][i] = arr[0][i]+dp[0][i-1];
		for(int i = 1; i<=r; i++) {
			dp[i][0] = arr[i][0]+dp[i-1][0];
			for(int j = 1; j<m; j++) {
				dp[i][j] = Math.min(dp[i-1][j]+arr[i][j], dp[i][j-1]+arr[i][j]);
			}
			for(int j = m-2; j>=0; j--) {
				dp[i][j] = Math.min(dp[i][j],arr[i][j]+dp[i][j+1]);
			}
		}
		System.out.println(dp[r][c]);
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
