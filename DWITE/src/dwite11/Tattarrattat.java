package dwite11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tattarrattat {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			char[]c = next().toCharArray();
			int[][]dp = new int[c.length+1][c.length+1];
			int max = 1;
			for(int j = 0; j<c.length; j++) {
				for(int k = 0; k<c.length-j-1; k++) {
					dp[j+1][k+1] = Math.max(dp[j+1][k], dp[j][k+1]);
					if(c[j]==c[c.length-k-1]) {
						dp[j+1][k+1] = Math.max(dp[j+1][k+1], dp[j][k]+2);
						if(dp[j+1][k+1]>=max) {
							max = dp[j+1][k+1];
							if(c.length-j-k-1>1) max++;
						}
					}
				}
			}
			System.out.println(max);
		}
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
