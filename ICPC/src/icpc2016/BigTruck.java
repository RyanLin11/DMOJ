package icpc2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BigTruck {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Edge{
		int v, w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static int n;
	static ArrayList<Edge>[]adj;
	static boolean[]visited;
	static int max = 0, minDist = Integer.MAX_VALUE;
	static int[]val, items;
	public static void main(String[] args) throws IOException {
		n = readInt();
		val = new int[n+1];
		adj = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i<n+1; i++) adj[i] = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			val[i] = readInt();
		}
		int m = readInt();
		for(int i = 0; i<m; i++) {
			int u = readInt();
			int v = readInt();
			int w = readInt();
			adj[u].add(new Edge(v,w));
			adj[v].add(new Edge(u,w));
		}
		minDist = dijkstra(1);
		if(minDist==Integer.MAX_VALUE) {
			System.out.println("impossible");
			return;
		}
		System.out.println(minDist+" "+items[n]);
	}
	public static int dijkstra(int src) {
		int[]dist = new int[n+1];
		boolean[]visited = new boolean[n+1];
		items = new int[n+1];
		for(int i = 0; i<dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		items[src] = val[src];
		for(int i = 0; i<n; i++) {
			int u = minIndex(dist, visited);
			visited[u] = true;
			for(Edge e: adj[u]) {
				int v = e.v;
				int w = e.w;
				if(dist[u]!=Integer.MAX_VALUE && !visited[v] && dist[v]>=dist[u]+w) {
					if(dist[v]==dist[u]+w) {
						items[v] = Math.max(items[v],items[u]+val[v]);
					} else {
						items[v] = items[u]+val[v];
						dist[v] = dist[u]+w;
					}
				}
			}
		}
		return dist[n];
	}
	public static int minIndex(int[]dist, boolean[]visited) {
		int minIndex = 0;
		int minDist = Integer.MAX_VALUE;
		for(int i = 1; i<dist.length; i++) {
			if(dist[i]<minDist && !visited[i]) {
				minIndex = i;
				minDist = dist[i];
			}
		}
		return minIndex;
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
