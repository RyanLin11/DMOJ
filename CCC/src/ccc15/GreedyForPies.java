package ccc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GreedyForPies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int[]add;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		arr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = readInt();
		}
		int M = readInt();
		add = new int[M+1];
		for(int i = 1; i<=M; i++) {
			add[i] = readInt();
		}
		Arrays.sort(add);
		int[][][]dp = new int[N+2][M+2][M+2];
		for(int i = 0; i<=N; i++) {
			for(int k = 0; k<=M; k++) {
				for(int j = k+1; j>0; j--) {
					int ans = 0;
					if(i>0) {
						ans = Math.max(ans, dp[i-1][j][k]);
						if(j<=k) {
							ans = Math.max(ans, arr[i]+dp[i-1][j+1][k]);
							ans = Math.max(ans, add[k]+dp[i-1][j][k-1]);
							if(j+1<=k) {
								ans = Math.max(ans, add[k]+dp[i][j+1][k-1]);
							}
						} else {
							ans = Math.max(ans, arr[i]);
						}
						if(i-1>0) {
							ans = Math.max(ans, arr[i]+dp[i-2][j][k]);
						}
					}
					if(j<=k) {
						ans = Math.max(ans, dp[i][j+1][k]);
						if(j+1<=k) {
							ans = Math.max(ans, dp[i][j+1][k-1]);
						}
					}
					dp[i][j][k] = ans;
				}
			}
		}
		System.out.println(dp[N][1][M]);
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
