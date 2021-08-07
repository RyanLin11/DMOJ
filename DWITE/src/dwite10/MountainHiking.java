package dwite10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class MountainHiking {
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
		for(int i = 0; i<5; i++) {
			int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
			int[][]arr = new int[10][10];
			for(int j = 0; j<10; j++) {
				String str = next();
				for(int k = 0; k<10; k++) {
					arr[j][k] = Integer.parseInt(str.charAt(k)+"");
				}
			}
			//try out each of the leftmost positions
			int minDistance = Integer.MAX_VALUE;
			for(int j = 0; j<10; j++) {
				Queue<Pair>q = new LinkedList<>();
				boolean[][]visited = new boolean[10][10];
				q.offer(new Pair(j,0,0));
				visited[j][0] = true;
				while(!q.isEmpty()) {
					Pair p = q.poll();
					if(p.c==9) {
						minDistance = Math.min(minDistance,p.dist);
						break;
					}
					for(int k = 0; k<dir.length; k++) {
						int dr = p.r+dir[k][0];
						int dc = p.c+dir[k][1];
						if(dr>=0 && dr<10 && dc>=0 && dc<10 && Math.abs(arr[dr][dc]-arr[p.r][p.c])<=1 && !visited[dr][dc]) {
							visited[dr][dc] = true;
							q.offer(new Pair(dr,dc,p.dist+1));
						}
					}
				}
			}
			if(minDistance==Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(minDistance);
			}
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
