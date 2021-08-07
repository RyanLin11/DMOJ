package ccc98;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class MountainPassage {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c, cost;
		public Pair(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int l = 0; l<t; l++) {
			if(l!=0) System.out.println();
			int n = readInt();
			int[][]arr = new int[n][n];
			int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr[i][j] = readInt();
				}
			}
			int base = arr[0][0];
			Queue<Pair>q = new LinkedList<>();
			boolean[][]visited = new boolean[n][n];
			q.offer(new Pair(0,0,0));
			visited[0][0] = true;
			boolean canReach = false;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(p.r==n-1 && p.c==n-1) {
					System.out.println(p.cost);
					canReach = true;
					break;
				}
				for(int i = 0; i<dir.length; i++) {
					int dr = p.r+dir[i][0];
					int dc = p.c+dir[i][1];
					if(dr>=0 && dr<n && dc>=0 && dc<n && Math.abs(arr[dr][dc]-arr[p.r][p.c])<=2 && !visited[dr][dc]) {
						visited[dr][dc] = true;
						if(arr[dr][dc]>base || arr[p.r][p.c]>base) {
							q.offer(new Pair(dr,dc,p.cost+1));
						} else {
							q.offer(new Pair(dr,dc,p.cost));
						}
					}
				}
			}
			if(!canReach) System.out.println("CANNOT MAKE THE TRIP");
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
