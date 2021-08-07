package ddr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TudorAndThePusheens {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	public static void main(String[]args) throws IOException {
		int n = readInt();
		int m = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			list[y].add(x);
		}
		int s = readInt();
		int t = readInt();
		Queue<Integer>q = new LinkedList<>();
		boolean[]visited = new boolean[n+1];
		int[]dist = new int[n+1];
		q.offer(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			if(u==t) {
				System.out.println(m-dist[u]);
				return;
			}
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
					dist[v]=dist[u]+1;
				}
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
