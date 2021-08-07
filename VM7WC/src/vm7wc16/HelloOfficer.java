package vm7wc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class HelloOfficer {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int M = readInt();
		int B = readInt();
		int Q = readInt();
		int[][]graph = new int[N+1][N+1];
		for(int i = 0; i<M; i++) {
			int s = readInt();
			int e = readInt();
			int w = readInt();
			graph[s][e] = w;
			graph[e][s] = w;
		}
		int[]dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[]visited = new boolean[N+1];
		dist[B] = 0;
		for(int i = 0; i<N; i++) {
			int u = minIndex(dist, visited);
			if(u==-1) continue;
			visited[u] = true;
			for(int v = 0; v<N+1; v++) {
				if(graph[u][v]!=0 && !visited[v] && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		for(int i = 0; i<Q; i++) {
			int n = readInt();
			if(!visited[n]) System.out.println(-1);
			else System.out.println(dist[n]);
		}
	}
	public static int minIndex(int[]dist, boolean[]visited) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i<dist.length; i++) {
			if(dist[i]<min && !visited[i]) {
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
