package dmopc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class WishUponAStar {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int n, m;
	static int[] parent, low, disc;
	static boolean[]visited;
	static int time = 1;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		list = new ArrayList[n+1];
		parent = new int[n+1];
		low = new int[n+1];
		disc = new int[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i<n+1; i++) {
			parent[i] = -1;
		}
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		
	}
	static boolean ap = false;
	public static void dfs(int u) {
		int children = 0;
		visited[u] = true;
		disc[u] = low[u] = time++;
		for(int v: list[u]) {
			if(!visited[v]) {
				children++;
				parent[v] = u;
				dfs(v);
				low[u] = Math.min(disc[u], low[v]);
				if(parent[u]==-1 && children>1) {
					ap = true;
				}
				if(parent[u]!=-1 && low[u]>=disc[u]) {
					ap = true;
				}
			} else {
				if(parent[u]!=v) {
					low[u] = Math.min(disc[u], low[v]);
				}
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
