package vm7wc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class JaydenStudiesTrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer>[]list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<n-1; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		int[]dist = new int[n+1];
		boolean[]visited = new boolean[n+1];
		Queue<Integer>q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
					dist[v]=dist[u]+1;
				}
			}
		}
		int max = 0;
		int vertex = 0;
		for(int i = 1; i<dist.length; i++) {
			if(dist[i]>max) {
				max = dist[i];
				vertex = i;
			}
		}
		q.offer(vertex);
		dist = new int[n+1];
		visited = new boolean[n+1];
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
					dist[v]=dist[u]+1;
				}
			}
		}
		max = 0;
		for(int i = 1; i<dist.length; i++) {
			max = Math.max(max, dist[i]);
		}
		System.out.println(max);
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
