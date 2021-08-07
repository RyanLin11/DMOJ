package gfssoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class HideNSeek {
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
	static int[]r, c;
	static int[][]dir = {{0, 1}, {0,-1}, {1,0}, {-1,0}};
	static int[][]dist;
	static int N, M, T;
	static int INF = Integer.MAX_VALUE/100;
	public static void main(String[] args) throws IOException {
		N = readInt();
		M = readInt();
		T = readInt()+1;
		arr = new char[N][M];
		r = new int[T];
		c = new int[T];
		int idx = 0;
		int si = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = next().toCharArray();
			for(int j = 0; j<M; j++) {
				if(arr[i][j] == 'H' || arr[i][j] == 'G') {
					r[idx] = i;
					c[idx] = j;
					if(arr[i][j] == 'G') {
						si = idx;
					}
					idx++;
				}
			}
		}
		dist = new int[T][T];
		for(int i = 0; i<T; i++) {
			for(int j = i+1; j<T; j++) {
				int d = bfs(r[i], c[i], r[j], c[j]);
				dist[i][j] = d;
				dist[j][i] = d;
			}
		}
		System.out.println(permute(si, (1<<si)));
	}
	public static int permute(int from, int bit) {
		if(bit == ((1<<T)-1)) return 0;
		int min = INF;
		for(int i = 0; i<T; i++) {
			if(((1<<i) & bit) == 0) {
				min = Math.min(min, dist[from][i] + permute(i, (1<<i) | bit));
			}
		}
		return min;
	}
	public static int bfs(int r1, int c1, int r2, int c2) {
		boolean[][]vis = new boolean[arr.length][arr[0].length];
		int[][]dis = new int[arr.length][arr[0].length];
		Queue<Pair>q = new LinkedList<>();
		q.offer(new Pair(r1, c1));
		vis[r1][c1] = true;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.r == r2 && p.c == c2) {
				return dis[p.r][p.c];
			}
			for(int i = 0; i<dir.length; i++) {
				int dr = p.r+dir[i][0], dc = p.c+dir[i][1];
				if(dr>=0 && dr<arr.length && dc>=0 && dc<arr[0].length && !vis[dr][dc] && arr[dr][dc]!='X') {
					dis[dr][dc] = dis[p.r][p.c] + 1;
					vis[dr][dc] = true;
					q.offer(new Pair(dr, dc));
				}
			}
		}
		return -1;
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
