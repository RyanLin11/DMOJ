package contest4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SquirrelElection {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[]dp = new long[5001];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		int tpt = 0;
		for(int i = 0; i<n; i++) {
			int v = readInt()/2+1, p = readInt();
			for(int j = dp.length-1; j>=p; j--) {
				if(dp[j-p]!=Long.MAX_VALUE) dp[j] = Math.min(dp[j],dp[j-p]+v);
			}
			tpt+=p;
		}
		long min = Long.MAX_VALUE;
		for(int i = tpt/2+1; i<dp.length; i++) {
			min = Math.min(min, dp[i]);
		}
		System.out.println(min);
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
