package cco13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tourney {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]tree, arr, lvl;
	static int N, M;
	public static void main(String[] args) throws IOException {
		N = readInt(); 
		M = readInt();
		int len = 1<<N;
		arr = new int[len+1];
		lvl = new int[len+1];
		tree = new int[4*len+4];
		for(int i = 1; i<=len; i++) {
			arr[i] = readInt();
		}
		construct(1, 1, 1, len);
		lvl[tree[1]] = N;
		for(int i = 0; i<M; i++) {
			char c = readCharacter();
			if(c=='R') {
				int x = readInt(), v = readInt();
				arr[x] = v;
				update(1, 1, x, 1, len);
				lvl[tree[1]] = N;
			} else if(c=='W') {
				System.out.println(tree[1]);
			} else {
				System.out.println(lvl[readInt()]);
			}
		}
		
	}
	public static void construct(int v, int d, int l, int r) {
		if(l==r) {
			tree[v] = l;
		} else {
			int mid = (l+r)/2;
			construct(v*2, d+1, l, mid);
			construct(v*2+1, d+1, mid+1, r);
			if(arr[tree[v*2]]>arr[tree[v*2+1]]) {
				tree[v] = tree[v*2];
				lvl[tree[v*2+1]] = N - d;
			} else {
				tree[v] = tree[v*2+1];
				lvl[tree[v*2]] = N - d;
			}
		}
	}
	public static void update(int v, int d, int x, int l, int r) {
		if(l==r) {
			tree[v] = l;
		} else {
			int mid = (l+r)/2;
			if(x<=mid) {
				update(v*2, d+1, x, l, mid);
			} else {
				update(v*2+1, d+1, x, mid+1, r);
			}
			if(arr[tree[v*2]]>arr[tree[v*2+1]]) {
				tree[v] = tree[v*2];
				lvl[tree[v*2+1]] = N - d;
			} else {
				tree[v] = tree[v*2+1];
				lvl[tree[v*2]] = N - d;
			}
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
