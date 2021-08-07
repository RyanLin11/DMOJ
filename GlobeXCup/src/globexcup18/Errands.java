package globexcup18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Errands {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int Q = readInt();
		int c = readInt();
		ArrayList<Integer>[]list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		boolean[]visited = new boolean[n+1];
		int[]dist = new int[n+1];
		Queue<Integer>q = new LinkedList<>();
		visited[c] = true;
		Arrays.fill(dist, -1);
		dist[c] = 0;
		q.offer(c);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: list[u]) {
				if(!visited[v]) {
					dist[v] = dist[u]+1;
					visited[v] = true;
					q.offer(v);
				}
			}
		}
		for(int i = 0; i<Q; i++) {
			int a = readInt();
			int b = readInt();
			if(dist[a]==-1 || dist[b]==-1) {
				System.out.println("This is a scam!");
			} else {
				System.out.println(dist[a]+dist[b]);
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
