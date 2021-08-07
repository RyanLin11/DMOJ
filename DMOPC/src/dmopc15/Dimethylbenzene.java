package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Dimethylbenzene {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int[]dist;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		int m = readInt();
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		dist[1] = 0;
		System.out.println(dfs(1,-1)?"YES":"NO");
	}
	public static boolean dfs(int u, int prev) {
		for(int v: list[u]) {
			if(dist[v]>=0) {
				if(dist[v]-dist[u]==5) {
					return true;
				}
			} else {
				dist[v] = dist[u]+1;
				dfs(v, u);
			}
		}
		return false;
	}
	public static String next () throws IOException {
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
