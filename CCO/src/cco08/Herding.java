package cco08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Herding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent, rank;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		char[][]arr = new char[n][m];
		parent = new int[n*m];
		rank = new int[n*m];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for(int i = 0; i<n; i++) {
			arr[i] = next().toCharArray();
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				int u = i*m+j;
				if(parent[u]==u) {
					int r = i, c = j;
					if(arr[i][j]=='N') {
						r--;
					} else if(arr[i][j]=='S') {
						r++;
					} else if(arr[i][j]=='E') {
						c++;
					} else {
						c--;
					}
					int v = r*m+c;
					while(union(u,v)) {
						u = v;
						if(arr[r][c]=='N') {
							r--;
						} else if(arr[r][c]=='S') {
							r++;
						} else if(arr[r][c]=='E') {
							c++;
						} else {
							c--;
						}
						v = r*m+c;
					}
				}
			}
		}
		int count = 0;
		for(int i = 0; i<parent.length; i++) {
			if(parent[i]==i) {
				count++;
			}
		}
		System.out.println(count);
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	public static boolean union(int u, int v) {
		int x = find(u);
		int y = find(v);
		if(x==y) {
			return false;
		} else {
			if(rank[x]<rank[y]) {
				parent[x] = y;
			} else if(rank[x]>rank[y]) {
				parent[y] = x;
			} else {
				parent[x] = y;
				rank[y]++;
			}
		}
		return true;
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
