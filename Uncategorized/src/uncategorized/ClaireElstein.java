package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ClaireElstein {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static long[]dp, ways;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		int[]indegree = new int[N+1];
		for(int i = 0; i<M; i++) {
			int x = readInt(), y = readInt();
			list[x].add(y);
			indegree[y]++;
		}
		ways = new long[N+1];
		dp = new long[N+1];
		long ans = 0;
		for(int i = 1; i<ways.length; i++) {
			if(indegree[i] == 0) {
				ways(i);
				ans += f(i);
				ans %= mod;
			}
		}
		System.out.println(ans);
	}
	public static long f(int u) {
		if(dp[u] > 0) return dp[u];
		long sum = 0;
		for(int v: list[u]) {
			sum += ways[v];
			sum += f(v);
			sum %= mod;
		}
		return dp[u] = sum % mod;
	}
	public static long ways(int u) {
		if(list[u].isEmpty()) return ways[u] = 1;
		if(ways[u] != 0) return ways[u];
		long w = 0;
		for(int v: list[u]) {
			w += ways(v);
			w %= mod;
		}
		return ways[u] = w % mod;
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