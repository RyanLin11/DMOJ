package ccc08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Maze {
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
		int t = readInt();
		int[][]cross = {{0,1},{0,-1},{1,0},{-1,0}};
		int[][]vert = {{1,0},{-1,0}};
		int[][]horiz = {{0,1},{0,-1}};
		for(int i = 0; i<t; i++) {
			int r = readInt();
			int c = readInt();
			char[][]arr = new char[r][c];
			for(int j = 0; j<r; j++) {
				arr[j] = next().toCharArray();
			}
			Queue<Pair>q = new LinkedList<>();
			boolean[][]visited = new boolean[r][c];
			visited[0][0] = true;
			q.offer(new Pair(0,0,1));
			boolean canReach = false;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(p.r==r-1 && p.c==c-1) {
					System.out.println(p.dist);
					canReach = true;
					break;
				}
				if(arr[p.r][p.c]=='+') {
					for(int j = 0; j<cross.length; j++) {
						int dr = p.r+cross[j][0];
						int dc = p.c+cross[j][1];
						if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='*' && !visited[dr][dc]) {
							visited[dr][dc] = true;
							q.offer(new Pair(dr,dc,p.dist+1));
						}
					}
				} else if(arr[p.r][p.c]=='-') {
					for(int j = 0; j<horiz.length; j++) {
						int dr = p.r+horiz[j][0];
						int dc = p.c+horiz[j][1];
						if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='*' && !visited[dr][dc]) {
							visited[dr][dc] = true;
							q.offer(new Pair(dr,dc,p.dist+1));
						}
					}
				} else if(arr[p.r][p.c]=='|') {
					for(int j = 0; j<vert.length; j++) {
						int dr = p.r+vert[j][0];
						int dc = p.c+vert[j][1];
						if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='*' && !visited[dr][dc]) {
							visited[dr][dc] = true;
							q.offer(new Pair(dr,dc,p.dist+1));
						}
					}
				}
			}
			if(!canReach) System.out.println(-1);
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
