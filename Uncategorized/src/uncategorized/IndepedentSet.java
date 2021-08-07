package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IndepedentSet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][]dp;
	static ArrayList<Integer>[]list;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<N-1; i++) {
			int x = readInt(), y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		dp = new long[N+1][2];
		for(int i = 0; i<dp.length; i++) {
			for(int j = 0; j<dp[i].length; j++) {
				dp[i][j] = 1;
			}
		}
		System.out.println((f(1, -1, true) + f(1, -1, false))%mod);
	}
	public static long f(int u, int prev, boolean black) {
		if(dp[u][black?1:0] > 1) return dp[u][black?1:0];
		for(int v: list[u]) {
			if(v == prev) continue;
			if(black) {
				dp[u][1] *= f(v, u, false);
				dp[u][1] %= mod;
			} else {
				dp[u][0] *= (f(v, u, true) + f(v, u, false));
				dp[u][0] %= mod;
			}
		}
		
		return dp[u][black?1:0];
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
