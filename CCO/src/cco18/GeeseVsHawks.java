package cco18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GeeseVsHawks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//read input
		int n = readInt();
		char[]ac = next().toCharArray();
		int[]a = new int[n];
		for(int i = 0; i<a.length; i++) a[i] = readInt();
		char[]bc = next().toCharArray();
		int[]b = new int[n];
		for(int i = 0; i<b.length; i++) b[i] = readInt();
		//run dp table algorithm
		long[][]dp = new long[n][n];
		long max = 0;
		for(int i = 0; i<dp.length; i++) {
			if(ac[0]=='W' && bc[i]=='L' && a[0]>b[i] || ac[0]=='L' && bc[i]=='W' && a[0]<b[i]) {
				dp[0][i] = Math.max(max, a[0]+b[i]);
				max = Math.max(max, dp[0][i]);
			} else {
				dp[0][i] = max;
			}
		}
		for(int i = 1; i<dp.length; i++) {
			if(ac[i]=='W' && bc[0]=='L' && a[i]>b[0] || ac[i]=='L' && bc[0]=='W' && a[i]<b[0]) {
				dp[i][0] = Math.max(a[i]+b[0], dp[i-1][0]);
			} else {
				dp[i][0] = dp[i-1][0];
			}
			for(int j = 1; j<dp[i].length; j++) {
				if(ac[i]=='W' && bc[j]=='L' && a[i]>b[j] || ac[i]=='L' && bc[j]=='W' && a[i]<b[j]) {
					dp[i][j] = Math.max(Math.max(dp[i-1][j-1]+a[i]+b[j], dp[i-1][j]), dp[i][j-1]);
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
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
