package dstests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class SegmentTreeTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]min, gcd, arr, gcdcnt;
	static class Pair{
		int gcd, cnt;
		public Pair(int gcd, int cnt) {
			this.gcd = gcd;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		arr = new int[N+1];
		min = new int[4*N+4];
		gcd = new int[4*N+4];
		gcdcnt = new int[4*N+4];
		for(int i = 1; i<=N; i++) {
			arr[i] = readInt();
		}
		construct(1, 1, N);
		for(int i = 0; i<M; i++) {
			char c = readCharacter();
			if(c=='C') {
				int x = readInt(), v = readInt();
				update(1, x, v, 1, N);
				arr[x] = v;
			} else if(c=='M') {
				int l = readInt(), r = readInt();
				System.out.println(queryMin(1, 1, N, l, r));
			} else if(c=='G') {
				int l = readInt(), r = readInt();
				System.out.println(querygcd(1, 1, N, l, r));
			} else if(c=='Q') {
				int l = readInt(), r = readInt();
				System.out.println(querygcdcnt(1, 1, N, l, r).cnt);
			}
		}
	}
	public static void construct(int v, int l, int r) {
		if(l==r) {
			min[v] = arr[l];
			gcd[v] = arr[l];
			gcdcnt[v] = 1;
		} else {
			int mid = (l+r)/2;
			construct(v*2, l, mid);
			construct(v*2+1, mid+1, r);
			min[v] = Math.min(min[v*2], min[v*2+1]);
			gcd[v] = gcd(gcd[v*2], gcd[v*2+1]);
			if(gcd[v*2]==gcd[v]) gcdcnt[v] += gcdcnt[v*2];
			if(gcd[v*2+1]==gcd[v]) gcdcnt[v] += gcdcnt[v*2+1];
		}
	}
	public static void update(int v, int x, int val, int l, int r) {
		if(l==r) {
			min[v] = val;
			gcd[v] = val;
		} else {
			int mid = (l+r)/2;
			if(x<=mid) {
				update(v*2, x, val, l, mid);
			} else {
				update(v*2+1, x, val, mid+1, r);
			}
			min[v] = Math.min(min[v*2], min[v*2+1]);
			gcd[v] = gcd(gcd[v*2], gcd[v*2+1]);
			gcdcnt[v] = 0;
			if(gcd[v*2]==gcd[v]) gcdcnt[v] += gcdcnt[v*2];
			if(gcd[v*2+1]==gcd[v]) gcdcnt[v] += gcdcnt[v*2+1];
		}
	}
	public static int queryMin(int v, int l, int r, int tl, int tr) {
		if(tl>tr) return Integer.MAX_VALUE;
		if(tl==l && tr==r) {
			return min[v];
		} else {
			int mid = (l+r)/2;
			return Math.min(queryMin(v*2, l, mid, tl, Math.min(tr, mid)), queryMin(v*2+1, mid+1, r, Math.max(mid+1, tl), tr));
		}
	}
	public static int querygcd(int v, int l, int r, int tl, int tr) {
		if(tl==l && tr==r) {
			return gcd[v];
		} else {
			int mid = (l+r)/2;
			if(tr<=mid) {
				return querygcd(v*2, l, mid, tl, tr);
			} else if(tl>=mid+1) {
				return querygcd(v*2+1, mid+1, r, tl, tr);
			} else {
				return gcd(querygcd(v*2, l, mid, tl, mid), querygcd(v*2+1, mid+1, r, mid+1, tr));
			}
		}
	}
	public static Pair querygcdcnt(int v, int l, int r, int tl, int tr) {
		if(tl==l && tr==r) {
			return new Pair(gcd[v], gcdcnt[v]);
		} else {
			int mid = (l+r)/2;
			if(tr<=mid) {
				return querygcdcnt(v*2, l, mid, tl, tr);
			} else if(tl>=mid+1) {
				return querygcdcnt(v*2+1, mid+1, r, tl, tr);
			} else {
				Pair a = querygcdcnt(v*2, l, mid, tl, mid);
				Pair b = querygcdcnt(v*2+1, mid+1, r, mid+1, tr);
				int gcd = gcd(a.gcd, b.gcd);
				int cnt = 0;
				if(a.gcd==gcd) cnt += a.cnt;
				if(b.gcd==gcd) cnt += b.cnt;
				return new Pair(gcd, cnt);
			}
		}
	}
	public static int gcd(int x, int y) {
		if(y==0) return x;
		return gcd(y, x%y);
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
