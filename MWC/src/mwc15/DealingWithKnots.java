package mwc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class DealingWithKnots {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static boolean[]visited;
	static int a, b;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<n; i++) {
			int u = readInt();
			int v = readInt();
			list[u].add(v);
		}
		a = readInt();
		b = readInt();
		if(dfs(a)) {
			System.out.println("Tangled");
		} else {
			System.out.println("Not Tangled");
		}
	}
	
	public static boolean dfs(int s) {
		if(s==b) {
			return true;
		}
		visited[s] = true;
		for(int v: list[s]) {
			if(!visited[v]) {
				if(dfs(v)) {
					return true;
				}
			}
		}
		return false;
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
