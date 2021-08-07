package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lethal {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int g = readInt();
		for(int i = 0; i<g; i++) {
			int n = readInt();
			int[]arr = new int[n];
			for(int j = 0; j<arr.length; j++) {
				arr[j] = readInt();
			}
			int a = readInt(), b = readInt();
			int[]dp = new int[(1<<n)];
			boolean lethal = false;
			for(int j = 0; j<dp.length && !lethal; j++) {
				for(int k = n-1; k>=0; k--) {
					if((j>>k)!=0) break;
					if((dp[j]>=a && dp[j^((1<<(k+1))-1)]>=b)||(dp[j]>=b && dp[j^((1<<(k+1))-1)]>=a)) {
						lethal = true;
						break;
					}
					dp[j|(1<<k)] = dp[j]+arr[k];
				}
			}
			System.out.println(lethal?"LETHAL":"NOT LETHAL");
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
