package dwite08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class SchoolsAMaze {
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
	static int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static char[][]arr;
	static int[]r;
	static int[]c;
	public static void main(String[] args) throws IOException {
		arr = new char[10][18];
		r = new int[12];
		c = new int[12];
		for(int i = 0; i<10; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<18; j++) {
				int as = (int)(arr[i][j]);
				if(as>=65 && as<=76) {
					r[as%65] = i;
					c[as%65] = j;
				}
			}
		}
		for(int i = 0; i<5; i++) {
			int dist = 0;
			String str = next();
			if(str.length()==1) {
				System.out.println(0);
				continue;
			}
			for(int j = 1; j<str.length(); j++) {
				if(str.charAt(j)==str.charAt(j-1)) {
					continue;
				} else {
					dist+=distance(str.charAt(j-1),str.charAt(j));
				}
			}
			System.out.println(dist);
		}
	}
	public static int distance(char a, char b) {
		boolean[][]visited = new boolean[10][18];
		Queue<Pair>q = new LinkedList<>();
		int aIndex = ((int)a)%65;
		int bIndex = ((int)b)%65;
		q.offer(new Pair(r[aIndex], c[aIndex], 0));
		visited[r[aIndex]][c[aIndex]] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r==r[bIndex] && p.c==c[bIndex]) {
				return p.dist;
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<10 && dc>=0 && dc<18 && arr[dr][dc]!='#' && !visited[dr][dc]) {
					visited[dr][dc] = true;
					q.offer(new Pair(dr,dc,p.dist+1));
					
				}
			}
		}
		return 0;
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
