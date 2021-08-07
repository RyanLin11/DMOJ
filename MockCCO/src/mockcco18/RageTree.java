package mockcco18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RageTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]segmax, segmin, arr;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		segmax = new int[4*N+2];
		segmin = new int[4*N+2];
		arr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = readInt();
		}
		build(1,1,N);
		for(int i = 0; i<Q; i++) {
			int l = readInt(), r = readInt();
			System.out.println(querymax(1,1,N,l,r)-querymin(1,1,N,l,r));
		}
	}
	public static void build(int v, int l, int r) {
		if(l==r) {
			segmax[v] = arr[l];
			segmin[v] = arr[l];
		} else {
			int mid = (l+r)/2;
			build(v*2, l, mid);
			build(v*2+1, mid+1, r);
			segmax[v] = Math.max(segmax[v*2],segmax[v*2+1]);
			segmin[v] = Math.min(segmin[v*2], segmin[v*2+1]);
		}
	}
	public static int querymin(int v, int l, int r, int ql, int qr) {
		if(ql>qr) {
			return Integer.MAX_VALUE;
		} else if(ql==l && qr==r) {
			return segmin[v];
		}
		int mid = (l+r)/2;
		return Math.min(querymin(v*2, l, mid, ql, Math.min(mid, qr)),querymin(v*2+1, mid+1, r, Math.max(ql, mid+1), qr));
	}
	public static int querymax(int v, int l, int r, int ql, int qr) {
		if(ql>qr) {
			return Integer.MIN_VALUE;
		} else if(ql==l && qr==r) {
			return segmax[v];
		}
		int mid = (l+r)/2;
		return Math.max(querymax(v*2, l, mid, ql, Math.min(mid, qr)),querymax(v*2+1, mid+1, r, Math.max(ql, mid+1), qr));
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
