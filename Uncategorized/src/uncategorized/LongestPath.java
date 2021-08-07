package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class LongestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]len;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		len = new int[n+1];
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			list[readInt()].add(readInt());
		}
		int max = 0;
		for(int i = 1; i<=n; i++) {
			max = Math.max(max, dfs(i));
		}
		System.out.println(max);
	}
	public static int dfs(int u) {
		if(len[u]!=0) return len[u];
		int max = 0;
		for(int v: list[u]) {
			max = Math.max(max, 1+dfs(v));
		}
		return len[u] = max;
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
