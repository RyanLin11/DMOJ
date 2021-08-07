package dmopc13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class CrossingField {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][]arr;
	static boolean[][]visited;
	static int n, h;
	static class Pair{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		n = readInt();
		h = readInt();
		arr = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr[i][j] = readInt();
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r==n-1 && p.c==n-1) {
				System.out.println("yes");
				return;
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<n && !visited[dr][dc] && Math.abs(arr[dr][dc]-arr[p.r][p.c])<=h) {
					q.offer(new Pair(dr,dc));
					visited[dr][dc] = true;
				}
			}
		}
		System.out.println("no");
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
