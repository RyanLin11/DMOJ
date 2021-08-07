package ccc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ConvexHull {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Edge implements Comparable<Edge>{
		int v, w, h;
		public Edge(int v, int w, int h) {
			this.v = v;
			this.w = w;
			this.h = h;
		}
		public int compareTo(Edge other) {
			return Integer.compare(this.w, other.w);
		}
	}
	static class Pair implements Comparable<Pair>{
		int v, w;
		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.w, other.w);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int K = readInt(), N = readInt(), M = readInt();
		ArrayList<Edge>[]list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			int a = readInt(), b = readInt(), t = readInt(), h = readInt();
			list[a].add(new Edge(b, t, h));
			list[b].add(new Edge(a, t, h));
		}
		int src = readInt(), dest = readInt();
		int[][]dist = new int[N+1][K];
		boolean[][]vis = new boolean[N+1][K];
		for(int i = 0; i<dist.length; i++) {
			if(i==src) continue;
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Edge>pq = new PriorityQueue<>();
		pq.offer(new Edge(src, 0, 0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			vis[e.v][e.h]=true; 
			for(Edge f: list[e.v]) {
				if(e.h+f.h<K && !vis[f.v][e.h+f.h] && dist[e.v][e.h]+f.w<dist[f.v][e.h+f.h]) {
					dist[f.v][e.h+f.h] = dist[e.v][e.h]+f.w;  
					pq.offer(new Edge(f.v,dist[f.v][e.h+f.h], e.h+f.h));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<dist[dest].length; i++) {
			min = Math.min(min, dist[dest][i]);
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
		
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
