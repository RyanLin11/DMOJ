package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Oversleep {
	static class Pair{
		int r, c, dist;
		public Pair(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		char[][]arr = new char[n][m];
		int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		Queue<Pair>q = new LinkedList<>();
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<m; j++) {
				if(arr[i][j]=='s') {
					q.offer(new Pair(i,j,0));
				}
			}
		}
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0];
				int dc = p.c+dir[i][1];
				if(dr>=0 && dr<n && dc>=0 && dc<m && arr[dr][dc]!='X') {
					if(arr[dr][dc]=='e') {
						System.out.println(p.dist);
						return;
					}
					q.offer(new Pair(dr,dc,p.dist+1));
					arr[dr][dc] = 'X';
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
