package boi09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Boxen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<2; i++) {
			int N = readInt();
			int[]parent = new int[N];
			for(int j = 0; j<N; j++) {
				parent[j] = j;
			}
			for(int j = 0; j<N; j++) {
				union(parent, j, readInt()-1);
			}
			HashSet<Integer>unique = new HashSet<>();
			for(int j = 0; j<N; j++) {
				unique.add(find(parent, j));
			}
			System.out.print(unique.size()+" ");
		}
		System.out.println();
	}
	public static int find(int[]parent, int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	public static void union(int[]parent, int u, int v) {
		int x = find(parent, u), y = find(parent, v);
		if(x != y) {
			parent[x] = y;
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
