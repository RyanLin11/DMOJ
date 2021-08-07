package dwite07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class FloorPlan {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static char[][]arr;
	static int[]posx = new int[5];
	static int[]posy = new int[5];
	static int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		int r = readInt();
		int c = readInt();
		arr = new char[r][c];
		for(int i = 0; i<r; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<c; j++) {
				int as = (int)(arr[i][j]);
				if(as>=48 && as<=57) {
					posx[Integer.parseInt((char)as+"")-1] = i;
					posy[Integer.parseInt((char)as+"")-1] = j;
				}
			}
		}
		for(int i = 0; i<5; i++) {
			Queue<Pair>q = new LinkedList<>();
			q.offer(new Pair(posx[i],posy[i]));
			arr[posx[i]][posy[i]] = '#';
			int sum = 1;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for(int j = 0; j<dir.length; j++) {
					int dr = p.r+dir[j][0];
					int dc = p.c+dir[j][1];
					if(dr>=0 && dr<r && dc>=0 && dc<c && arr[dr][dc]!='#') {
						arr[dr][dc]='#';
						q.offer(new Pair(dr,dc));
						sum++;
					}
				}
			}
			System.out.println(sum);
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
