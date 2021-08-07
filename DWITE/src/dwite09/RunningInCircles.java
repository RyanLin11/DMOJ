package dwite09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class RunningInCircles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]dist;
	static int[]visited;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		for(int t = 0; t<5; t++) {
			int n = readInt();
			list = new ArrayList[101];
			for(int i = 0; i<list.length; i++)list[i] = new ArrayList<>();
			dist = new int[101];
			visited = new int[101];
			int a = readInt();
			int b = readInt();
			list[a].add(b);
			for(int i = 1; i<n; i++) {
				int x = readInt();
				int y = readInt();
				list[x].add(y);
			}
			visited[a] = 1;
			dfs(a);
		}
	}
	public static void dfs(int u) {
		for(int v: list[u]) {
			if(visited[v]==0) {
				dist[v]=dist[u]+1;
				visited[v] = 1;
				dfs(v);
				visited[v] = 2;
			} else if(visited[v]==1){
				System.out.println(dist[u]-dist[v]+1);
			}
		}
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
