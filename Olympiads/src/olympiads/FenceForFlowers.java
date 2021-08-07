package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class FenceForFlowers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int[]arr = new int[n+1];
		for(int i = 1; i<=n; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		int[]w = new int[m];
		for(int i = 0; i<m; i++) {
			w[i] = readInt();
		}
		for(int i = w.length-2; i>=0; i--) {
			w[i] = Math.min(w[i], w[i+1]);
		}
		int[]dp = new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i = 1; i<=n; i++) {
			for(int j = i; j>=1; j--) {
				dp[i] = Math.min(dp[i], w[arr[i]-arr[j]]+dp[j-1]);
			}
		}
		System.out.println(dp[n]);
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
