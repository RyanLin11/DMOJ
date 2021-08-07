package cco05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class NumberMatrix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][]arr;
	static Set<Integer>set;
	static boolean[][]visited;
	static int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws IOException {
		m = readInt();
		n = readInt();
		arr = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				arr[i][j] = readInt();
			}
		}
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				for(int k = 0; k<10; k++) {
					set = new HashSet<>();
					visited = new boolean[n][m];
					set.add(i); set.add(j); set.add(k);
					for(int l = 0; l<m; l++) {
						if(set.contains(arr[0][l])) {
							if(dfs(0,l)) {
								System.out.println(i+" "+j+" "+k);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("-1 -1 -1");
	}
	public static boolean dfs(int r, int c) {
		if(r==n-1) return true;
		visited[r][c] = true;
		for(int i = 0; i<dir.length; i++) {
			int dr = r+dir[i][0];
			int dc = c+dir[i][1];
			if(dr>=0 && dr<n && dc>=0 && dc<m && !visited[dr][dc] && set.contains(arr[dr][dc])) {
				if(dfs(dr,dc)) return true;
			}
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
