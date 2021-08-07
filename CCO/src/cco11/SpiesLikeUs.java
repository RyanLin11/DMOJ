package cco11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpiesLikeUs {
	
	static int n, m;static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		int k = readInt();
		int[]parent = new int[n+m+1];
		int[]rank = new int[n+m+1];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for(int i = 0; i<k; i++) {
			int x = readInt();
			int y = readInt();
			if(!union(x,y,parent, rank)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	public static int find(int x, int[]parent) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x], parent);
	}
	public static boolean union(int u, int v, int[]parent, int[]rank) {
		int x = find(u, parent);
		int y = find(v, parent);
		if(x!=y) {
			if(rank[x]>rank[y]) {
				parent[y] = x;
			} else if(rank[x]<rank[y]) {
				parent[x] = y;
			} else {
				parent[x] = y;
				rank[y]++;
			}
			return true;
		}
		return false;
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
