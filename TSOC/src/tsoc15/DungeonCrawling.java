package tsoc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class DungeonCrawling {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static long count = 0;
	static boolean[]entrance;
	static int[]dist;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		n = readInt(); 
		m = readInt();
		entrance = new boolean[n];
		for(int i = 0; i<entrance.length; i++) entrance[i] = true;
		dist = new int[n];
		for(int i = 0; i<dist.length; i++) dist[i] = Integer.MAX_VALUE;
		list = new ArrayList[n];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[x].add(y);
			entrance[y] = false;
		}
		for(int i = 0; i<entrance.length; i++) {
			if(entrance[i]) {
				dfs(i,1);
			}
		}
		System.out.println(count%(1000000007));
		for(int i = 0; i<dist.length; i++) {
			if(dist[i]!=Integer.MAX_VALUE) {
				System.out.print(dist[i]+" ");
			}
		}
	}
	public static void dfs(int u, int d) {
		if(list[u].isEmpty()) {
			count++;
			dist[u] = Math.min(dist[u], d);
		}
		for(int v: list[u]) {
			dfs(v, d+1);
		}
	}
	public static String next () throws IOException {
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
