package coci18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Wand {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int n,m;
	static boolean[]visited, win;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		win = new boolean[n+1];
		for(int i = 0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			list[y].add(x);
		}
		if(list[1].isEmpty()) {
			win[1] = true;
		} else {
			dfs(1);
		}
		for(int i = 1; i<win.length; i++) {
			if(win[i]) System.out.print("1");
			else System.out.print("0");
		}
		System.out.println();
	}
	public static void dfs(int u) {
		visited[u] = true;
		for(int v: list[u]) {
			win[v] = true;
			if(!visited[v]) dfs(v);
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
