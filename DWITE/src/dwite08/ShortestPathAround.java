package dwite08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathAround {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]dir = {{0,1},{0,-1},{1,0},{1,1},{1,-1},{-1,0},{-1,-1},{-1,1}};
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
			Queue<Pair>q = new LinkedList<>();
			char[][]arr = new char[8][8];
			for(int j = 0; j<8; j++) {
				arr[j] = next().toCharArray();
				for(int k = 0; k<8; k++) {
					if(arr[j][k]=='A') q.offer(new Pair(j,k,0));
				}
			}
			boolean found = false;
			while(!q.isEmpty() && !found) {
				Pair p = q.poll();
				for(int j = 0; j<dir.length; j++) {
					int dr = p.r+dir[j][0];
					int dc = p.c+dir[j][1];
					if(dr>=0 && dr<8 && dc>=0 && dc<8 && arr[dr][dc]!='#') {
						q.offer(new Pair(dr,dc,p.depth+1));
						if(arr[dr][dc]=='B') {
							System.out.println(p.depth+1);
							found = true;
							break;
						}
						arr[dr][dc]='#';
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
