package bts17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class WetMud {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]parent;
	static boolean[]spot;
	static class Pair implements Comparable<Pair>{
		int p, t;
		public Pair(int p, int t) {
			this.p = p;
			this.t = t;
		}
		public int compareTo(Pair other) {
			if(this.t>other.t) {
				return 1;
			} else if(this.t<other.t) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int j = readInt();
		parent = new int[n+2];
		spot = new boolean[n+2];
		for(int i = 0; i<n+2; i++) {
			parent[i] = i;
		}
		if(j>n) {
			System.out.println(0);
			return;
		}
		Pair[]arr = new Pair[m];
		for(int i = 0; i<m; i++) {
			arr[i] = new Pair(readInt(),readInt());
		}
		Arrays.sort(arr);
		spot[0] = true; spot[n+1] = true;
		for(Pair p: arr) {
			spot[p.p]= true; 
			for(int i = p.p+1; i<=Math.min(p.p+j, n+1); i++) {
				if(spot[i])union(p.p,i);
			}
			for(int i = p.p-1; i>=Math.max(0, p.p-j); i--) {
				if(spot[i])union(p.p,i);
			}
			if(find(0)==find(n+1)) {
				System.out.println(p.t);
				return;
			}
		}
		System.out.println(-1);
	}
	public static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	public static void union(int u, int v) {
		int x = find(u);
		int y = find(v);
		if(x!=y) {
			parent[x] = y;
			//lo[y] = Math.min(lo[y], lo[x]);
			//hi[y] = Math.max(hi[y], hi[x]);
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
