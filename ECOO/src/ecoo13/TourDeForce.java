package ecoo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TourDeForce {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]arr;
	static int[][]dp;
	static int nc;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<10; i++) {
			nc = readInt();
			arr = new int[nc][2];
			dp = new int[nc][10];
			for(int j = 0; j<nc; j++) {
				arr[j][0] = readInt();
				arr[j][1] = readInt();
			}
			System.out.println(f(0,9));
		}

	}
	public static int f(int c, int n) {
		if(n<0) return Integer.MIN_VALUE/2;
		if(c==nc) return 0;
		if(dp[c][n]!=0) return dp[c][n];
		return dp[c][n] = Math.max(f(c+1,9)-1,Math.max(arr[c][0]+arr[c][1]+f(c+1,n-2), arr[c][0]-1+f(c+1,9)));
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
