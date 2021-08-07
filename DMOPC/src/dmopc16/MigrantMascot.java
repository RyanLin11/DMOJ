package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class MigrantMascot {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent;
	static int[]rank;
	static int[]val;
	static boolean[]visited;
	static ArrayList<Edge>[]list;
	static class Edge implements Comparable<Edge>{
		int u, v, cost;
		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		public int compareTo(Edge other) {
			if(this.cost>other.cost) {
				return -1;
			} else if(this.cost<other.cost) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	static int count = 0;
	public static void main(String[] args) throws IOException {
		int n = readInt(); 
		int m = readInt();
		parent = new int[n+1];
		rank = new int[n+1];
		val = new int[n+1];
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
			list[i] = new ArrayList<>();
		}
		Edge[]edges = new Edge[m];
		for(int i = 0; i<m; i++) {
			int a = readInt();
			int b = readInt();
			int p = readInt();
			edges[i] = new Edge(a,b, p);
		}
		Arrays.sort(edges);
		for(int i = 0; i<edges.length; i++) {
			if(count==n-1) break;
			union(edges[i].u,edges[i].v, edges[i].cost);
		}
		//New
		Stack<Edge>s = new Stack<>();
		s.push(new Edge(1, Integer.MAX_VALUE));
		while(!s.isEmpty()) {
			Edge e = s.pop();
			visited[e.v]= true; 
			val[e.v]=e.cost;
			for(Edge a: list[e.v]) {
				if(!visited[a.v]) {
					s.push(new Edge(a.v, Math.min(e.cost, a.cost)));
				}
			}
		}
		
		//New
		//dfs(1, Integer.MAX_VALUE);
		val[1] = 0;
		for(int i = 1; i<val.length; i++) {
			System.out.println(val[i]);
		}
	}
	public static void dfs(int u, int max) {
		visited[u] = true;
		val[u] = max;
		for(Edge e: list[u]) {
			if(!visited[e.v]) {
				dfs(e.v, Math.min(max, e.cost));
			}
		}
	}
	public static int find(int u) {
		if(parent[u]==u) return u;
		return parent[u] = find(parent[u]);
	}
	public static void union(int u, int v, int cost) {
		int x = find(u);
		int y = find(v);
		if(x!=y) {
			count++;
			list[u].add(new Edge(v,cost));
			list[v].add(new Edge(u, cost));
			if(rank[x]>rank[y]) {
				parent[y] = x;
			} else if(rank[x]<rank[y]) {
				parent[x] = y;
			} else {
				parent[x] = y;
				rank[y]++;
			}
		}
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
