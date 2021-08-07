package coci17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Deda {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]seg;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		seg = new int[4*N];
		Arrays.fill(seg, Integer.MAX_VALUE);
		for(int i = 0; i<Q; i++) {
			char c = readCharacter();
			int x = readInt(), y = readInt();
			if(c=='M') {
				update(1, 1, N, y, x);
			} else {
				int q = query(1, 1, N, y, N, x);
				System.out.println(q==Integer.MAX_VALUE? -1: q);
			}
		}
	}
	public static void update(int v, int l, int r, int x, int val) {
		if(l==r) {
			seg[v] = val;
		} else {
			int mid = (l+r)/2;
			if(x<=mid) update(v*2, l, mid, x, val);
			else update(v*2+1, mid+1, r, x, val);
			seg[v] = Math.min(seg[v*2], seg[v*2+1]);
		}
	}
	public static int query(int v, int l, int r, int tl, int tr, int k) {
		if(tl>tr) return Integer.MAX_VALUE;
		if(l==r) {
			if(seg[v]<=k) return l;
			else return Integer.MAX_VALUE;
		}
		int mid = (l+r)/2;
		if(l==tl && r==tr) {
			if(seg[v*2]<=k) return query(v*2, l, mid, tl, Math.min(mid, tr), k);
			else if(seg[v*2+1]<=k) return query(v*2+1, mid+1, r, Math.max(mid+1, tl), tr, k);
			else return Integer.MAX_VALUE;
		} else {
			return Math.min(query(v*2, l, mid, tl, Math.min(tr, mid), k), query(v*2+1, mid+1, r, Math.max(mid+1, tl), tr, k));
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
