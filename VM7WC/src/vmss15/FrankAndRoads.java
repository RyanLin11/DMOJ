package vmss15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class FrankAndRoads {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		int n = readInt();
		int m = readInt();
		int g = readInt();
		int[]food = new int[g];
		for(int i = 0; i<g; i++) {
			food[i] = readInt();
		}
		int[][]arr = new int[n+1][n+1];
		for(int i = 0; i<m; i++) {
			int s = readInt();
			int e = readInt();
			int w = readInt();
			arr[s][e] = w;
		}
		int[]dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[]visited = new boolean[n+1];
		dist[0] = 0;
		for(int i = 0; i<n-1; i++) {
			int u = minIndex(dist, visited);
			visited[u] = true;
			for(int v = 0; v<n; v++) {
				if(arr[u][v]!=0 && !visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+arr[u][v]<dist[v]) {
					dist[v] = dist[u]+arr[u][v];
				}
			}
		}
		int count = 0;
		for(int i = 0; i<food.length; i++) {
			if(dist[food[i]]<=t) {
				count++;
			}
		}
		System.out.println(count);
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
