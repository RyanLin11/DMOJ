package dwite07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class TrainRide {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r,c,dist;
		public Pair(int x, int y, int dist) {
			this.r = x;
			this.c = y;
			this.dist = dist;
		}
	}
	public static void main(String[] args) throws IOException {
		int[][]dir = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}};
		for(int i = 0; i<5; i++) {
			char[][]arr = new char[5][10];
			for(int j = 0; j<5; j++) {
				Arrays.fill(arr[j], ' ');
			}
			String s = br.readLine();
			int row = 0;
			Pair start = new Pair(0,0,0);
			Pair end = new Pair(0,0,0);
			for(int j = 0; !s.contains("x"); j++) {
				for(int k = 0; k<s.length(); k++) {
					arr[j][k] = s.charAt(k);
					if(arr[j][k]=='S') {
						start = new Pair(j,k,0);
					} else if(arr[j][k]=='E') {
						end = new Pair(j,k,0);
					}
				}
				s = br.readLine();
			}
			Queue<Pair>q = new LinkedList<>();
			q.offer(start);
			boolean found = false;
			while(!q.isEmpty() && !found) {
				Pair p = q.poll();
				for(int j = 0; j<dir.length; j++) {
					int dr = p.r+dir[j][0];
					int dc = p.c+dir[j][1];
					if(dr>=0 && dr<5 && dc>=0 && dc<10 && arr[dr][dc]!=' ') {
						if(arr[dr][dc]=='E') {
							System.out.println(p.dist+1);
							found = true;
							break;
						}
						q.offer(new Pair(dr,dc,p.dist+1));
						arr[dr][dc] = ' ';
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
