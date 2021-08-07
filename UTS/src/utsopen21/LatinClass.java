package utsopen21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LatinClass {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[]bit;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		long[]dp = new long[N+1];
		long sum = 1;
		int max = 0;
		dp[0] = 1;
		for(int i = 1; i<=N; i++) {
			int x = readInt();
			if(x >= max) {
				dp[i] = sum;
				sum *= 2;
				max = x;
			} else {
				dp[i] = dp[i-1];
				sum += dp[i];
			}
			sum %= 1000000007;
		}
		System.out.println(dp[N]);
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
