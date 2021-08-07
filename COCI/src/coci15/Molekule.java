package coci15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Molekule {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Edge>[]list;
	static int[]arr;
	static class Edge{
		int v, n;
		public Edge(int v, int n) {
			this.v = v;
			this.n = n;
		}
		
	}
	static Edge[]edges;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		edges = new Edge[n-1];
		for(int i = 0; i<n-1; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(new Edge(y,i));
			list[y].add(new Edge(x,i));
			edges[i] = new Edge(x,y);
		}
		arr = new int[n-1];
		//dfs(1, -1, true);
		/*for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}*/
		//Lolz
		boolean[]polar = new boolean[n+1];
		boolean[]visited = new boolean[n+1];
		Queue<Integer>q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int u = q.poll();
			visited[u] = true;
			for(Edge e: list[u]) {
				if(!visited[e.v]) {
					polar[e.v] = !polar[u];
					if(polar[e.v]) {
						if(edges[e.n].v==u) {
							arr[e.n]=0;
						} else {
							arr[e.n]=1;
						}
					} else {
						if(edges[e.n].v==u) {
							arr[e.n]=1;
						} else {
							arr[e.n]=0;
						}
					}
					q.offer(e.v);
				}
			}
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void dfs(int u, int prev, boolean polar) {
		for(Edge e: list[u]) {
			if(e.v!=prev) {
				if(polar) {
					if(edges[e.n].v==u) {
						arr[e.n]=0; 
					} else {
						arr[e.n]=1; 
					}
				} else {
					if(edges[e.n].v==u) {
						arr[e.n]=1; 
					} else {
						arr[e.n]=0; 
					}
				}
				dfs(e.v, u, !polar);
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
