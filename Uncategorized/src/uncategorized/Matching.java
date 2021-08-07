package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matching {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][]arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = readInt();
			}
		}
		long[]dp = new long[(int)Math.pow(2,n)];
		dp[0] = 1;
		for(int i = 0; i<dp.length; i++) {
			int x = i, cnt = 0;
			while(x>0) {
				x=x&(x-1);
				cnt++;
			}
			for(int j = 0; j<n; j++) {
				int k = i|(1<<j);
				if(k!=i)dp[i|(1<<j)]+=(arr[cnt][j]*dp[i])%mod;
			}
		}
		System.out.println(dp[(int)Math.pow(2, n)-1]%mod);
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
