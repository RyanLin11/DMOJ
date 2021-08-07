package coci09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Vuk {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]graph;
	static class Pair implements Comparable<Pair>{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public int compareTo(Pair other) {
			if(graph[r][c]<graph[other.r][other.c]) {
				return 1;
			} else if(graph[r][c]>graph[other.r][other.c]) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		char[][]c = new char[n][m];
		graph = new int[n][m];
		for(int i = 0; i<graph.length; i++) Arrays.fill(graph[i], -1);
		int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		Queue<Pair>q = new LinkedList<>();
		Pair start = new Pair(0,0), end = new Pair(0,0);
		for(int i = 0; i<c.length; i++) {
			c[i] = next().toCharArray();
			for(int j = 0; j<c[i].length; j++) {
				if(c[i][j]=='+') {
					q.offer(new Pair(i,j));
					graph[i][j] = 0;
				} else if(c[i][j]=='V') {
					start = new Pair(i,j);
				} else if(c[i][j]=='J') {
					end = new Pair(i,j);
				}
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0], dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && graph[dr][dc]<0) {
					graph[dr][dc] = graph[p.r][p.c]+1;
					q.offer(new Pair(dr,dc));
				}
			}
		}
		int[][]dis = new int[n][m];
		for(int i = 0; i<dis.length; i++) Arrays.fill(dis[i], -1);
		boolean[][]vis = new boolean[n][m];
		PriorityQueue<Pair>pq = new PriorityQueue<>();
		pq.offer(start);
		dis[start.r][start.c] = graph[start.r][start.c]; 
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			vis[p.r][p.c] = true; 
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0], dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && !vis[dr][dc] && dis[dr][dc]<Math.min(dis[p.r][p.c], graph[dr][dc])) {
					dis[dr][dc] = Math.min(dis[p.r][p.c],graph[dr][dc]);
					pq.offer(new Pair(dr,dc));
				}
			}
		}
		System.out.println(dis[end.r][end.c]);
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
