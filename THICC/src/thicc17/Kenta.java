package thicc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kenta {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[]ac;
	static char[]str;
	static int[][]dp;
	public static void main(String[] args) throws IOException {
		ac = next().toCharArray();
		int t = readInt();
		double min = Integer.MAX_VALUE;
		for(int i = 0; i<t; i++) {
			int n = readInt();
			double ans = 0;
			for(int j = 0; j<n; j++) {
				str = next().toCharArray();
				dp = new int[ac.length+1][str.length+1];
				for(int k = 0; k<=str.length; k++) dp[0][k] = k;
				for(int k = 1; k<=ac.length; k++) {
					dp[k][0] = k;
					for(int l = 1; l<=str.length; l++) {
						if(ac[k-1]==str[l-1]) dp[k][l] = dp[k-1][l-1];
						else dp[k][l] = Math.min(1+dp[k-1][l-1],Math.min(1+dp[k-1][l], 1+dp[k][l-1]));
					}
				}
				ans+=dp[ac.length][str.length];
			}
			ans/=n;
			min = Math.min(min, ans);
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
