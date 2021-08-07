package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class SurpriseTeleport {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c, dist;
		public Pair(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		int r = readInt();
		int c = readInt();
		Queue<Pair>q = new LinkedList<>();
		int startr = readInt();
		int startc = readInt();
		q.offer(new Pair(startr,startc, 0));
		int endr = readInt();
		int endc = readInt();
		char[][]arr = new char[r][c];
		for(int i = 0; i<r; i++) {
			arr[i] = next().toCharArray();
		}
		int t = readInt();
		for(int i = 0; i<t; i++) {
			arr[readInt()][readInt()] = 'T';
		}
		int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean[][]visited = new boolean[r][c];
		visited[startr][startc] = true;
		int dist = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r==endr && p.c==endc) {
				dist = p.dist;
				break;
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='X' &&!visited[dr][dc]) {
					q.offer(new Pair(dr,dc,p.dist+1));
					visited[dr][dc] = true;
				}
			}
		}
		q.clear();
		visited = new boolean[r][c];
		q.offer(new Pair(startr,startc,0));
		visited[startr][startc] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='X' && !visited[dr][dc]) {
					if(arr[dr][dc]=='T') {
						if(dist<p.dist+1) {
							System.out.println(0);
						} else {
							System.out.println(dist-(p.dist+1));
						}
						return;
					}
					q.offer(new Pair(dr,dc,p.dist+1));
					visited[dr][dc] = true;
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
