package ccc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombiningRiceballs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]psa = new int[n+1];
		int[]arr = new int[n+1];
		for(int i = 1; i<psa.length; i++) {
			arr[i] = readInt();
			psa[i] = arr[i]+psa[i-1];
		}
		int ans = 0;
		boolean[][]dp = new boolean[n+1][n+1];//true if can be combined
		for(int i = 1; i<=n; i++) {
			dp[i][i] = true;
			ans = Math.max(ans, psa[i]-psa[i-1]);
		}
		for(int i = 1; i<n; i++) {
			for(int j = 1; j+i<=n; j++) {
				for(int k = j; k<=j+i && !dp[j][j+i]; k++) {
					if(dp[j][k]&&dp[k+1][j+i]&&(psa[k]-psa[j-1]==psa[j+i]-psa[k])) {
						dp[j][j+i] = true;
						ans = Math.max(ans, psa[j+i]-psa[j-1]);
						break;
					}
				}
				int l = j, r = j+i, lsum = arr[j], rsum = arr[j+i];
				while(l<r-1) {
					if(lsum==rsum && dp[j][l] && dp[l+1][r-1] && dp[r][j+i]) {
						dp[j][j+i] = true;
						ans = Math.max(ans, psa[j+i]-psa[j-1]);
						break;
					}
					if(lsum<=rsum) {
						l++; lsum+=arr[l];
					} else {
						r--; rsum+=arr[r];
					}
				}
			}
		}
		System.out.println(ans);
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
