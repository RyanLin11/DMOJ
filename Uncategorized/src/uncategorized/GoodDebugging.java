package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodDebugging {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[]lazy;
	static int[]seg;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), L = readInt();
		seg = new int[4*N];
		lazy = new boolean[4*N];
		lazy[1] = true;
		for(int i = 0; i<M; i++) {
			int a = readInt()-1, b = readInt()-1;
			update(1, 0, N-1, a, b);
			int ans = query(1, 0, N-1, L);
			System.out.println(ans>=0?ans+1: "AC?");
		}
	}
	public static void update(int v, int l, int r, int tl, int tr) {
		int mid = (l+r)/2;
		if(lazy[v] && l!=r) {
			lazy[v*2] = !lazy[v*2];
			lazy[v*2+1] = !lazy[v*2+1];
			seg[v*2] = mid-l+1 - seg[v*2];
			seg[v*2+1] = r-mid - seg[v*2+1];
			seg[v] = seg[v*2] + seg[v*2+1];
			lazy[v] = false;
		}
		if(tl==l && tr==r) {
			if(l!=r) {
				lazy[v*2] = !lazy[v*2];
				lazy[v*2+1] = !lazy[v*2+1];
				seg[v*2] = mid-l+1 - seg[v*2];
				seg[v*2+1] = r-mid - seg[v*2+1];
				seg[v] = seg[v*2] + seg[v*2+1];
				lazy[v] = false;
			} else {
				seg[v] = r-l+1 - seg[v];
			}
		} else {
			if(tr <= mid) {
				update(v*2, l, mid, tl, tr);
			} else if(tl > mid) {
				update(v*2+1, mid+1, r, tl, tr);
			} else {
				update(v*2, l, mid, tl, mid);
				update(v*2+1, mid+1, r, mid+1, tr);
			}
			seg[v] = seg[v*2] + seg[v*2+1];
		}
	}
	public static int query(int v, int l, int r, int x) {
		int mid = (l+r)/2;
		if(lazy[v]) {
			if(l!=r) {
				lazy[v*2] = !lazy[v*2];
				lazy[v*2+1] = !lazy[v*2+1];
				seg[v*2] = mid-l+1 - seg[v*2];
				seg[v*2+1] = r-mid - seg[v*2+1];
				seg[v] = seg[v*2] + seg[v*2+1];
				lazy[v] = false;
			}
		} 
		if(l == r) {
			return x==seg[v]? l: -1;
		} else {
			if(seg[v*2] >= x) {
				return query(v*2, l, mid, x);
			} else {
				return query(v*2+1, mid+1, r, x - seg[v*2]);
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
