package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BirthdayGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent, rank, arr, vis;
	static boolean[]cycle;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		parent = new int[n+1];
		rank = new int[n+1];
		cycle = new boolean[n+1];
		arr = new int[n+1];
		vis = new int[n+1];
		for(int i = 0; i<n+1; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for(int i = 1; i<n+1; i++) {
			arr[i] = readInt();
			union(i, arr[i]);
		}
		for(int i = 1; i<n+1; i++) {
			if(parent[i]==i && cycle[i]) {
				int[]dist = new int[n+1];
				vis[i] = i;
				for(int j = i; true; j = arr[j]) {
					if(vis[arr[j]]==0) {
						dist[arr[j]] = dist[j]+1;
						vis[arr[j]] = i;
					} else {
						if(vis[arr[j]]!=i) break;
						min = Math.min(min, dist[j]+1-dist[arr[j]]);
						break;
					}
				}
			}
		}
		System.out.println(min);
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		return find(parent[x]);
	}
	public static void union(int u, int v) {
		int x = find(u);
		int y = find(v);
		if(x!=y) {
			if(rank[x]<rank[y]) {
				parent[x] = y;
			} else if(rank[x]>rank[y]) {
				parent[y] = x;
			} else {
				parent[x] = y;
				rank[y]++;
			}
		} else {
			cycle[x] = true;
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
