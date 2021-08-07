package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Slimes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[][]arr = new long[n][n];
		arr[0][0] = readLong();
		for(int i = 1; i<n; i++) {
			long x = readLong();
			for(int j = i; j>=0; j--) {
				arr[j][i] = arr[j][i-1]+x;
			}
		}
		long[][]dp = new long[n][n];
		for(int i = 0; i<dp.length; i++) {
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}
		for(int i = 0; i<n; i++) {
			dp[i][i] = 0;
			for(int j = i-1; j>=0; j--) {
				for(int k = j; k<i; k++) {
					dp[j][i] = Math.min(dp[j][i], dp[j][k]+dp[k+1][i]+arr[j][k]+arr[k+1][i]);
				}
			}
		}
		System.out.println(dp[0][n-1]);
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
