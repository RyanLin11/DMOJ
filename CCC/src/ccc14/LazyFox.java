package ccc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class LazyFox {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Edge implements Comparable<Edge>{
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge other) {
			return Integer.compare(this.w, other.w);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]x = new int[N];
		int[]y = new int[N];
		ArrayList<Edge>list = new ArrayList<>();
		int[]dist = new int[N];
		int[]pow = new int[20001];
		for(int i = 0; i<pow.length; i++) {
			pow[i] = i*i;
		}
		for(int i = 0; i<N; i++) {
			x[i] = readInt();
			y[i] = readInt();
			for(int j = 0; j<i; j++) {
				list.add(new Edge(i,j,pow[Math.abs(x[i]-x[j])]+pow[Math.abs(y[i]-y[j])]));
			}
			dist[i] = pow[Math.abs(x[i])] + pow[Math.abs(y[i])];
		}
		Collections.sort(list);
		int[]dp = new int[N];
		int[]rec = new int[N];
		int[]pre = new int[N];
		int max = 0;
		for(Edge e: list) {
			if(pre[e.u]!=e.w) {
				pre[e.u] = e.w;
				rec[e.u] = dp[e.u];
			}
			if(pre[e.v]!=e.w) {
				pre[e.v] = e.w;
				rec[e.v] = dp[e.v]; 
			}
			dp[e.v] = Math.max(dp[e.v], rec[e.u]+1); 
			dp[e.u] = Math.max(dp[e.u], rec[e.v]+1);
			if(dist[e.v]>e.w) max = Math.max(max, dp[e.v]);
			if(dist[e.u]>e.w) max = Math.max(max, dp[e.u]); 
		}
		System.out.println(max+1);
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
