package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SegmentTreeTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[]seg, arr;
	public static void main(String[] args) throws IOException {
		N = readInt(); M = readInt();
		seg = new int[4*N];
		arr = new int[N];
		//Arrays.fill(seg, Integer.MAX_VALUE);
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		construct(1, 0, N-1);
		for(int i = 0; i<M; i++) {
			char c = readCharacter();
			if(c=='M') {
				update(1, 0, N-1, readInt(), readInt());
			} else {
				System.out.println(query(1, 0, N-1, readInt(), readInt()));
			}
		}
	}
	public static void construct(int v, int l, int r) {
		if(l==r) {
			seg[v] = arr[l];
		} else {
			int mid = (l+r)/2;
			construct(v*2, l, mid);
			construct(v*2+1, mid+1, r);
			seg[v] = Math.min(seg[v*2], seg[v*2+1]);
		}
	}
	public static void update(int v, int l, int r, int i, int x) {
		if(l==r) {
			seg[v] = x;
		} else {
			int mid = (l+r)/2;
			if(i<=mid) {
				update(v*2, l, mid, i, x);
			} else {
				update(v*2+1, mid+1, r, i, x);
			}
			seg[v] = Math.min(seg[v*2], seg[v*2+1]);
		}
	}
	public static int query(int v, int l, int r, int tl, int tr) {
		if(tl>tr) return Integer.MAX_VALUE;
		if(l==tl && r==tr) {
			return seg[v];
		} else {
			int mid = (l+r)/2;
			return Math.min(query(v*2, l, mid, tl, Math.min(mid, tr)), query(v*2+1, mid+1, r, Math.max(mid+1, tl), tr));
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
