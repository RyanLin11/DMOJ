package ccc09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShopAndShip {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][]graph = new int[n+1][n+1];
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int x = readInt();
			int y = readInt();
			int w = readInt();
			graph[x][y] = w;
			graph[y][x] = w;
		}
		int k = readInt();
		int[]cost = new int[n+1];
		for(int i = 0; i<cost.length; i++) cost[i] = -1;
		for(int i = 0; i<k; i++) {
			cost[readInt()] = readInt();
		}
		int[]dist = new int[n+1];
		for(int i = 0; i<dist.length; i++) dist[i] = Integer.MAX_VALUE;
		int d = readInt();
		dist[d] = 0;
		boolean[]visited = new boolean[n+1];
		for(int i = 1; i<n; i++) {
			int u = minIndex(dist, visited);
			visited[u] = true;
			for(int v = 1; v<=n; v++) {
				if(graph[u][v]!=0 && !visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<cost.length; i++) {
			if(cost[i]!=-1) min = Math.min(min, cost[i]+dist[i]);
		}
		System.out.println(min);
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
