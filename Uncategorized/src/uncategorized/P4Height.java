package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4Height {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]dp = new int[n];
		int[]num = new int[n];
		for(int i = 0; i<n; i++) {
			num[i] = readInt();
			int max = num[i];
			for(int j = 0; j<i; j++) {
				if(num[j]<num[i]) {
					max = Math.max(max, dp[j]+num[i]);
				}
			}
			dp[i] = max;
		}
		int max = 0;
		for(int i = 0; i<dp.length; i++) max = Math.max(max, dp[i]);
		System.out.println(max);
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
