package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class BobsVideoGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair{
		int v, w;
		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), t = readInt();
		int[][]arr = new int[n+1][n+1];
		ArrayList<Pair>[]list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		for(int i = 0; i<m; i++) {
			list[readInt()].add(new Pair(readInt(),readInt()));
		}
		for(int i = 1; i<=n; i++) {
			Queue<Pair>q = new LinkedList<>();
			q.offer(new Pair(i,Integer.MIN_VALUE));
			arr[i][i] = Integer.MIN_VALUE;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for(Pair v: list[p.v]) {
					if(Math.max(arr[i][p.v], v.w)<arr[i][v.v]) {
						q.offer(v);
						arr[i][v.v]=Math.max(arr[i][p.v],v.w); 
					}
				}
			}
		}
		for(int i = 0; i<t; i++) {
			int x = readInt(), y = readInt();
			System.out.println(arr[x][y]==Integer.MAX_VALUE?-1:arr[x][y]);
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