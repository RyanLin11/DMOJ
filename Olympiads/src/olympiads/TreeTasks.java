package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class TreeTasks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[]dist;
	static boolean[]visited;
	static int[]from;
	static ArrayList<Pair>[]list;
	static class Pair{
		int v, w;
		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		n = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<n-1; i++) {
			int u = readInt();
			int v = readInt();
			int w = readInt();
			list[u].add(new Pair(v, w));
			list[v].add(new Pair(u, w));
		}
		dfsHelper(1);
		int max = 0;
		int endpoint = 0;
		for(int i = 0; i<dist.length; i++) {
			if(dist[i]>max) {
				max = dist[i];
				endpoint = i;
			}
		}
		dfsHelper(endpoint);
		max = 0;
		endpoint = 0;
		for(int i = 0; i<dist.length; i++) {
			if(dist[i]>max) {
				max = dist[i];
				endpoint = i;
			}
		}
		//int l = dist[i];
		//int r = dist[endpoint]-dist[i];
		int radius = Integer.MAX_VALUE;
		for(int i = endpoint; i!=0; i = from[i]) {
			radius = Math.min(radius, Math.max(dist[i], dist[endpoint]-dist[i]));
		}
		System.out.println(dist[endpoint]);
		System.out.println(radius);
	}
	public static void dfs(int u) {
		for(Pair p: list[u]) {
			if(!visited[p.v]) {
				dist[p.v]= dist[u]+p.w;
				from[p.v]= u; 
				visited[p.v] = true;
				dfs(p.v);
			}
		}
	}
	public static void dfsHelper(int u) {
		visited = new boolean[n+1];
		dist = new int[n+1];
		from = new int[n+1];
		visited[u] = true;
		dfs(u);
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
