package ccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
//2hr 1 min left
public class EscapeRoom {
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
		int[][]grid = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				grid[i][j] = readInt();
			}
		}
		ArrayList<Integer>[]list = new ArrayList[1000001];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1; i<Math.min(list.length, 1001); i++) {
			for(int j = i; j<list.length; j+=i) {
				list[j].add(i);
			}
		}
		boolean[][]vis = new boolean[n][m];
		boolean[]numvis = new boolean[1000001];
		Queue<Pair>q = new LinkedList<>();
		q.offer(new Pair(0,0));
		vis[0][0] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r==n-1 && p.c==m-1) {
				System.out.println("yes");
				return;
			}
			if(numvis[grid[p.r][p.c]])continue; 
			int x = grid[p.r][p.c];
			numvis[x] = true;
			for(int y: list[x]) {
				if(y>Math.sqrt(x))break;
				int dx = y-1, dy = x/y-1;
				if(dx<n && dy<m && !vis[dx][dy]) {
					q.offer(new Pair(dx,dy));
					vis[dx][dy] = true;
				}
				if(dy<n && dx<m && !vis[dy][dx]) {
					q.offer(new Pair(dy,dx));
					vis[dy][dx] = true;
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
