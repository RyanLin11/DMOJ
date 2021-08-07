package ecoo14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class FutureCity {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		for(int k = 0; k<10; k++) {
			int r = readInt();
			int c = readInt();
			int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
			Queue<Pair>q = new LinkedList<>();
			int sr = readInt();
			int sc = readInt();
			q.offer(new Pair(sr,sc));
			ArrayList<Pair>[][]list = new ArrayList[r][c];
			for(int i = 0; i<r; i++) {
				for(int j = 0; j<c; j++) {
					list[i][j] = new ArrayList<>();
				}
			}
			int[][]dist = new int[r][c];
			for(int i = 0; i<r; i++) {
				Arrays.fill(dist[i], -1);
			}
			int endr = readInt();
			int endc = readInt();
			int n = readInt();
			for(int i = 0; i<n; i++) {
				int r1 = readInt();
				int c1 = readInt();
				int r2 = readInt();
				int c2 = readInt();
				list[r1][c1].add(new Pair(r2,c2));
				list[r2][c2].add(new Pair(r1,c1));
			}
			dist[sr][sc] = 0;
			if(!list[sr][sc].isEmpty()) {
				q.add(list[sr][sc].get(0));
				dist[list[sr][sc].get(0).r][list[sr][sc].get(0).c]= 0; 
			}
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(dist[endr][endc]!=-1) {
					System.out.println(dist[endr][endc]);
					break;
				}
				for(int i = 0; i<dir.length; i++) {
					int dr = p.r+dir[i][0];
					int dc = p.c+dir[i][1];
					if(dr>=0 && dr<r && dc>=0 && dc<c && dist[dr][dc]==-1) {
						dist[dr][dc] = dist[p.r][p.c]+1;
						q.offer(new Pair(dr,dc));
						for(Pair a: list[dr][dc]) {
							if(dist[a.r][a.c]==-1) {
								q.offer(new Pair(a.r,a.c));
								dist[a.r][a.c] = dist[p.r][p.c]+1; 
							}
						}
					}
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
