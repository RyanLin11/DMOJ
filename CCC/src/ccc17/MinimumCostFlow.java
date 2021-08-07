package ccc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class MinimumCostFlow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Edge implements Comparable<Edge> {
		int u, v, c;
		boolean cur;
		boolean added;
		public Edge(int u, int v, int c, boolean cur) {
			this.u = u;
			this.v = v;
			this.c = c;
			this.cur = cur;
		}
		public int compareTo(Edge other) {
			if(this.c < other.c) {
				return -1;
			} else if(this.c > other.c) {
				return 1;
			} else {
				if(this.cur) return -1;
				else return 1;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), D = readInt();
		TreeSet<Edge>edges = new TreeSet<>();
		for(int i = 0; i<M; i++) {
			edges.add(new Edge(readInt(), readInt(), readInt(), i<N-1));
		}
		//run kruskal's
		int[]parent = new int[N+1];
		int[]p1 = new int[N+1];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
			p1[i] = i;
		}
		int ret = 0;
		int prev = -1;
		ArrayList<Edge>choice = new ArrayList<>();
		ArrayList<Edge>consider = new ArrayList<>();
		for(Edge e: edges) {
			if(union(parent, e.u, e.v)) {
				if(e.c != prev) {
					for(Edge c: consider) {
						union(p1, c.u, c.v);
					}
					consider.clear();
				}
				if(!e.cur){
					ret++;
					consider.add(e);
				} else {
					union(p1, e.u, e.v);
				}
				prev = e.c;
			} else if(e.cur && e.c <= D) {
				choice.add(e);
			}
		}
		if(prev >= D) {
			System.out.println(ret);
			return;
		}
		for(Edge e: choice) {
			if(union(p1, e.u, e.v)) {
				ret--;
				break;
			}
		}
		System.out.println(ret);
	}
	public static int find(int[]parent, int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	public static boolean union(int[]parent, int u, int v) {
		int x = find(parent, u);
		int y = find(parent, v);
		if(x!=y) {
			parent[x] = y;
			return true;
		}
		return false;
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
