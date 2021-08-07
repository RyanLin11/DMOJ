package ccc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class PhonomenalReviews {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, cnt = 0;
	static ArrayList<Integer>[]list;
	static boolean[]pho;
	static boolean[]vis;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt();
		list = new ArrayList[n];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		pho = new boolean[n];
		vis = new boolean[n];
		int r = 0;
		for(int i = 0; i<m; i++) {
			r = readInt();
			pho[r] = true;
		}
		for(int i = 0; i<n-1; i++) {
			int a = readInt(), b = readInt();
			list[a].add(b);
			list[b].add(a);
		}
		trim(r,-1);
		int[]dis1 = new int[n];
		dfs(r,-1,dis1);
		int max = 0, maxV = 0;
		for(int i = 0; i<n; i++) {
			if(dis1[i]>max) {
				max = dis1[i];
				maxV = i;
			}
		}
		int[]dis2 = new int[n];
		dfs(maxV,-1, dis2);
		max = 0;
		for(int i = 0; i<n; i++) {
			max = Math.max(max, dis2[i]);
		}
		System.out.println(cnt-max);
	}
	public static boolean trim(int u, int prev) {
		for(int v: list[u]) {
			if(v!=prev && trim(v,u))vis[u]=true;
		}
		return vis[u] = vis[u]||pho[u];
	}
	public static void dfs(int u, int prev, int[]dis) {
		for(int v: list[u]) {
			if(v!=prev && vis[v]) {
				dis[v] = dis[u]+1;
				cnt++;
				dfs(v, u, dis);
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
