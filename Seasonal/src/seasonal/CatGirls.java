package seasonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class CatGirls {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long w = readLong();
		long[]dp = new long[n+1];
		long[]dis = new long[n+1];
		long[]val = new long[n+1];
		int in = 1;
		for(int i = 0; i<n; i++) {
			char ch = readCharacter();
			if(ch=='A') {
				int p = readInt();
				int c = readInt();
				dis[in] = dis[in-1]+p;
				val[in] = val[in-1]+c;
				if(p>w) {
					dp[in] = dp[in-1];
					System.out.println(dp[in]);
					in++;
					continue;
				}
				int u = Arrays.binarySearch(dis,0,in+1,dis[in]-w);
				if(u<0) u = -u-1;
				dp[in] = Math.max(dp[in-1], val[in]-val[u]);
				System.out.println(dp[in]);
				in++;
			} else {
				dp[in-1] = 0;
				val[in-1] = 0;
				dis[in-1] = 0;
				in--;
			}
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
