package dwite07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Portals {
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
		int r = readInt();
		int c = readInt();
		char[][]arr = new char[r][c];
		int[]entr = new int[10];
		int[]entc = new int[10];
		int[]exr = new int[10];
		int[]exc = new int[10];
		int[]roomr = new int[5];
		int[]roomc = new int[5];
		int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
		for(int i = 0; i<arr.length; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<arr[i].length; j++) {
				int as = (int)(arr[i][j]);
				if(as>=49 && as<=53) {
					roomr[as%49] = i;
					roomc[as%49] = j;
				} else if(as>=65 && as<=74) {
					exr[as%65] = i;
					exc[as%65] = j;
				} else if(as>=97 && as<=106) {
					entr[as%97] = i;
					entc[as%97] = j;
				}
			}
		}
		for(int i = 0; i<5; i++) {
			Queue<Pair>q = new LinkedList<>();
			q.offer(new Pair(roomr[i], roomc[i]));
			boolean[][]visited = new boolean[r][c];
			visited[roomr[i]][roomc[i]] = true;
			int count = 0;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				count++;
				for(int j = 0; j<dir.length; j++) {
					int dr = p.r+dir[j][0];
					int dc = p.c+dir[j][1];
					if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='#' && !visited[dr][dc]) {
						q.offer(new Pair(dr,dc));
						visited[dr][dc] = true;
						int as = (int)arr[dr][dc];
						if(as>=97 && as<=106) {
							q.offer(new Pair(exr[as%97],exc[as%97]));
							visited[exr[as%97]][exc[as%97]] = true;
						}
					}
				}
			}
			System.out.println(count);
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
