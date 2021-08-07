package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class AVeryCoordinatedChristmas {
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
		int n = readInt();
		int m = readInt();
		int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		char[][]arr = new char[n][m];
		boolean[][]visited = new boolean[n][m];
		int[][]dist = new int[n][m];
		Queue<Pair>q = new LinkedList<>();
		Pair end = new Pair(0,0), pres = new Pair(0,0);
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<m; j++) {
				if(arr[i][j]=='O') q.offer(new Pair(i,j));
				else if(arr[i][j]=='X') end = new Pair(i,j);
				else if(arr[i][j]=='P') pres = new Pair(i,j);
			}
		}
		int dis = 0;
		visited[q.peek().r][q.peek().c]= true; 
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r==pres.r && p.c==pres.c) {
				dis+=dist[p.r][p.c];
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && !visited[dr][dc] && arr[dr][dc]!='#') {
					q.offer(new Pair(dr,dc));
					dist[dr][dc] = dist[p.r][p.c]+1;
					visited[dr][dc] = true;
				}
			}
		}
		if(dis==0) {
			System.out.println(-1);
			return;
		}
		q.clear();
		visited = new boolean[n][m];
		dist = new int[n][m];
		q.offer(pres);
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r==end.r && p.c==end.c) {
				dis+=dist[p.r][p.c];
				System.out.println(dis);
				return;
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && !visited[dr][dc] && arr[dr][dc]!='#') {
					q.offer(new Pair(dr,dc));
					dist[dr][dc] = dist[p.r][p.c]+1;
					visited[dr][dc] = true;
				}
			}
		}
		System.out.println(-1);
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
