package dwite09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class AirTravelPlanning {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			int n = readInt();
			int[][]graph = new int[n+1][n+1];
			HashMap<String, Integer>map = new HashMap<>();
			for(int j = 0; j<n; j++) {
				String src = next();
				String dest = next();
				map.putIfAbsent(src, map.size());
				map.putIfAbsent(dest, map.size());
				graph[map.get(src)][map.get(dest)] = readInt();
			}
			int src = map.get("YYZ");
			int dest = map.get("SEA");
			System.out.println(dijkstra(src,dest,graph));
		}
	}
	public static int dijkstra(int src, int dest, int[][]graph) {
		int V = graph.length;
		boolean[]visited = new boolean[V];
		int[]dist = new int[V];
		for(int i = 0; i<V; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		for(int i = 0; i<V-1; i++) {
			int u = minDistance(dist,visited);
			visited[u] = true;
			for(int v = 0; v<V; v++) {
				if(graph[u][v]!=0 && !visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		return dist[dest];
	}
	
	public static int minDistance(int[]dist, boolean[]visited) {
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
