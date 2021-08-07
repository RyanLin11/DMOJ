package classics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SingleSourceShortestPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int V = readInt();
		int E = readInt();
		int[][]graph = new int[V][V];
		for(int i = 0; i<E; i++) {
			int u = readInt()-1;
			int v = readInt()-1;
			int w = readInt();
			if(graph[u][v]!=0) {
				w = Math.min(w, graph[u][v]);
			}
			graph[u][v] = w;
			graph[v][u] = w;
		}
		dijkstra(graph);
	}
	public static void dijkstra(int[][]graph) {
		int V = graph.length;
		boolean[]visited = new boolean[V];
		int[]dist = new int[V];
		for(int i = 0; i<V; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		for(int i = 0; i<V-1; i++) {
			int u = minIndex(dist,visited);
			visited[u] = true;
			for(int v = 0; v<V; v++) {
				if(graph[u][v]!=0 && !visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		for(int i = 0; i<dist.length; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dist[i]);
			}
		}
	}
	public static int minIndex(int[]dist, boolean[]visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i<dist.length; i++) {
			if(!visited[i] && dist[i]<min) {
				min = dist[i];
				minIndex = i;
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
