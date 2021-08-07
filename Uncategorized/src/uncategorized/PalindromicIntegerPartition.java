package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PalindromicIntegerPartition {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[]dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		dp = new long[n+1];
		System.out.println(f(n));
	}
	public static long f(int n) {
		if(n==0) return 1;
		if(dp[n]!=0) return dp[n];
		long sum = 0;
		for(int i = 1; i<=n/2; i++) {
			sum+=f(n-i*2);
		}
		return dp[n]=1+sum;
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
