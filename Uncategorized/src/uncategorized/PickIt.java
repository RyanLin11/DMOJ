package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PickIt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		while(n!=0) {
			int[]arr = new int[n];
			for(int i = 0; i<n; i++) {
				arr[i] = readInt();
			}
			int[][]dp = new int[n][n];
			for(int i = 2; i<n; i++) {
				for(int j = 0; j+i<n; j++) {
					dp[j][j+i] = 1;
					for(int k = j+1; k<j+i; k++) {
						dp[j][j+i] = Math.max(dp[j][j+i], arr[j]+dp[j][k]+arr[k]+dp[k][j+i]+arr[j+i]);
					}
				}
			}
			System.out.println(dp[0][n-1]);
			n = readInt();
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
