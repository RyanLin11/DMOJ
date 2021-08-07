package bts16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class CherryTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]patch, weight;
	static int n, c, k;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		n = readInt();
		c = readInt();
		k = readInt();
		patch = new int[n];
		for(int i = 0; i<n; i++) {
			patch[i] = readInt();
		}
		weight = new int[n];
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<n-1; i++) {
			int u = readInt()-1;
			int v = readInt()-1;
			int parent = Math.min(u, v);
			int child = Math.max(u, v);
			list[parent].add(child);
			weight[child] = readInt();
		}
		dfs(0);
		if(weight[0]<=k && patch[0]>=c)count--;
		System.out.println(count);
	}
	static int count = 0;
	public static void dfs(int u) {
		for(int v:list[u]) {
			dfs(v);
			patch[u]+=patch[v];
			weight[u]+=weight[v];
		}
		if(weight[u]<=k && patch[u]>=c) {
			count++;
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
