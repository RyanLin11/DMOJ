package seasonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class AnExtraordinarilyCoordinatedChristmas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Pair>[]list;
	static class Pair{
		int v, w;
		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		int N  = readInt(), Q = readInt();
		list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<N-1; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			list[u].add(new Pair(v, w));
			list[v].add(new Pair(u, w));
		}
		//find first end point
		int[]dis = new int[N+1];
		dfs(dis, 1, -1);
		int p1 = findMaxIndex(dis);
		//DFS from end point and find other end point
		int[]dis1 = new int[N+1];
		dfs(dis1, p1, -1);
		int p2 = findMaxIndex(dis1);
		//DFS from second end point
		int[]dis2 = new int[N+1];
		dfs(dis2, p2, -1);
		for(int i = 0; i<Q; i++) {
			int x = readInt();
			System.out.println(Math.max(dis1[x], dis2[x]));
		}
	}
	public static void dfs(int[]dis, int u, int prev) {
		for(Pair p: list[u]) {
			if(p.v == prev) continue;
			dis[p.v] = dis[u] + p.w; 
			dfs(dis, p.v, u);
		}
	}
	public static int findMaxIndex(int[]dis) {
		int max = 0, maxIndex = 1;
		for(int i = 1; i<dis.length; i++) {
			if(dis[i] >= max) {
				max = dis[i];
				maxIndex = i;
			}
		}
		return maxIndex;
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
