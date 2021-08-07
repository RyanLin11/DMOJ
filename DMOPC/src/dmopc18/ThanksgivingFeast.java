package dmopc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class ThanksgivingFeast {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		int k = readInt();
		int a = readInt();
		int b = readInt();
		int[]shops = new int[k];
		for(int i = 0; i<k; i++) {
			shops[i] = readInt();
		}
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
		int[]dist1 = BFS(a);
		int[]dist2 = BFS(b);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<shops.length; i++) {
			min = Math.min(min, dist1[shops[i]]+dist2[shops[i]]);
		}
		System.out.println(min);
	}
	public static int[] BFS(int src) {
		Queue<Integer>q = new LinkedList<>();
		q.offer(src);
		int[]dist = new int[n+1];
		boolean[]visited = new boolean[n+1];
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u]+1;
					q.offer(v);
				}
			}
		}
		return dist;
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
