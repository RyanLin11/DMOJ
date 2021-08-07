package dmopc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BadBunnies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int min = Integer.MAX_VALUE;
	static int n, r;
	static HashSet<Integer>bunny = new HashSet<>();
	static HashSet<Integer>path = new HashSet<>();
	public static void main(String[] args) throws IOException {
		n = readInt();
		r = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<n-1; i++) {
			int a = readInt();
			int b = readInt();
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 0; i<r; i++) {
			bunny.add(readInt());
		}
		int x = readInt();
		int y = readInt();
		int cur = y;
		Queue<Integer>q = new LinkedList<>();
		int[]parent = new int[n+1];
		boolean[]visited = new boolean[n+1];
		q.offer(x);
		visited[x] = true;
		parent[x] = -1;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
					parent[v] = u;
				}
			}
		}
		while(cur!=-1) {
			path.add(cur);
			cur = parent[cur];
		}
		for(int a: path) {
			BFS(a);
		}
		System.out.println(min);
	}
	public static void BFS(int x) {
		Queue<Integer>q = new LinkedList<>();
		boolean[]visited = new boolean[n+1];
		int[]dist = new int[n+1];
		visited[x] = true;
		if(bunny.contains(x)) {
			min = 0;
			return;
		}
		q.offer(x);
		while(!q.isEmpty()) {
			int u = q.poll();
			if(dist[u]>=min) return;
			for(int v: list[u]) {
				if(!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u]+1;
					if(bunny.contains(v)) {
						min = dist[v];
						return;
					}
					if(!path.contains(v))q.offer(v);
				}
			}
		}
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