package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class SciFi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int n, m, a, b;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		a = readInt();
		b = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		int x = bfs(1,a);
		int y = bfs(a,b);
		if(x==-1||y==-1) System.out.println(-1);
		else System.out.println(x+y);
	}
	public static int bfs(int u, int v) {
		int[]dist = new int[n+1];
		boolean[]visited = new boolean[n+1];
		Queue<Integer>q = new LinkedList<>();
		q.offer(u);
		visited[u] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==v) return dist[v];
			for(int y: list[x]) {
				if(!visited[y]) {
					q.offer(y);
					dist[y]=dist[x]+1;
					visited[y] = true;
				}
			}
		}
		return -1;
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
