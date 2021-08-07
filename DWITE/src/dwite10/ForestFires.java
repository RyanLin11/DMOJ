package dwite10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class ForestFires {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c, depth;
		public Pair(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			char[][]arr = new char[10][10];
			Queue<Pair>q = new LinkedList<>();
			for(int j = 0; j<10; j++) {
				arr[j] = next().toCharArray();
				for(int k = 0; k<10; k++) {
					if(arr[j][k]=='F') {
						q.offer(new Pair(j,k,0));
					}
				}
			}
			int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
			int time = 0;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				time = Math.max(time, p.depth);
				for(int j = 0; j<dir.length; j++) {
					int dr = p.r + dir[j][0];
					int dc = p.c + dir[j][1];
					if(dr>=0 && dr<arr.length && dc>=0 && dc<arr.length && arr[dr][dc]=='T') {
						q.offer(new Pair(dr,dc,p.depth+1));
						arr[dr][dc] = 'F';
					}
				}
			}
			boolean treesLeft = false;
			for(int j = 0; j<10 && !treesLeft; j++) {
				for(int k = 0; k<10 && !treesLeft; k++) {
					if(arr[j][k]=='T') {
						treesLeft = true;
					}
				}
			}
			if(treesLeft) {
				System.out.println(-1);
			} else {
				System.out.println(time);
			}
			String temp = next();
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
