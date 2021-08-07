package ecoo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyTalk {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[]pow = new int[2002];
		pow[0] = 1;
		for(int i = 1; i<pow.length; i++) {
			pow[i] = pow[i-1]*131;
		}
		for(int i = 0; i<10; i++) {
			char[]arr = next().toCharArray();
			int[]ans = new int[arr.length+1];
			int[][]dp = new int[arr.length+1][arr.length+1];
			int max = 0;
			dp[1][1] = arr[0]-'A'+1;
			for(int j = 2; j<ans.length; j++) {
				int hash = 0;
				//ans[j] = ans[j-1];
				for(int k = 1; j-k>=0; k++) {
					hash+=(arr[j-k]-'A'+1)*pow[k-1];
					//System.out.println(j+" "+k+" "+hash);
					if(k<=j/2 && hash==dp[j-k][k]) {
						ans[j] = Math.max(ans[j], 2*k+ans[j-2*k]);
						//System.out.println(j+" match");
					}
					dp[j][k] = hash;
				}
				max = Math.max(max, ans[j]);
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
