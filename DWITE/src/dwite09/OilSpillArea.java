package dwite09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class OilSpillArea {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair {
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			char[][]arr = new char[10][10];
			Queue<Pair>q = new LinkedList<>();
			for(int j = 0; j<10; j++) {
				arr[j] = next().toCharArray();
				for(int k = 0; k<10; k++) {
					if(arr[j][k]=='A') {
						q.offer(new Pair(j,k));
					}
				}
			}
			int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
			int count = 1;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for(int j = 0; j<dir.length; j++) {
					int dr = p.r+dir[j][0];
					int dc = p.c+dir[j][1];
					if(dr>=0 && dr<arr.length && dc>=0 && dc<arr.length && arr[dr][dc]=='#') {
						q.offer(new Pair(dr,dc));
						arr[dr][dc]='.';
						count++;
					}
				}
			}
			System.out.println(count);
			String s = next();
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
