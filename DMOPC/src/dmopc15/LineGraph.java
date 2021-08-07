package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class LineGraph {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent, rank;
	static class Edge implements Comparable<Edge>{
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		public int compareTo(Edge other) {
			if(this.w<other.w) {
				return -1;
			} else if(this.w>other.w) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	static Edge[]edge;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		parent = new int[n];
		rank = new int[n];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for(int i = 0; i+k<n; i++) {
			union(i, i+k);
		}
		edge = new Edge[n-1];
		for(int i = 0; i<n-1; i++) {
			edge[i] = new Edge(i, i+1, readInt());
		}
		Arrays.sort(edge);
		int wt = 0;
		for(Edge e: edge) {
			if(union(e.u, e.v)) {
				wt+=e.w;
			}
		}
		System.out.println(wt);
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	public static boolean union(int u, int v) {
		int x = find(u);
		int y = find(v);
		if(x==y) {
			return false;
		} else {
			if(rank[x]<rank[y]) {
				parent[x] = y;
			} else if(rank[x]>rank[y]) {
				parent[y] = x;
			} else {
				parent[x] = y;
				rank[y]++;
			}
		}
		return true;
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
