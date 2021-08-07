package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SummingASequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][]dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		dp = new long[n][2];
		dp[0][0] = 0;
		dp[0][1] = Math.max(0, readInt());
		for(int i = 1; i<n; i++) {
			int x = readInt();
			dp[i][1] = dp[i-1][0]+x;
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
		}
		System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
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
