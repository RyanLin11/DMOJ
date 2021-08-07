package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DynamicRangeMinimumTest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]seg;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		seg = new int[4*N+1];
		Arrays.fill(seg, Integer.MAX_VALUE);
		for(int i = 1; i<=N; i++) {
			update(1, 1, N, i, readInt());
		}
		for(int i = 0; i<M; i++) {
			char c = readCharacter();
			if(c == 'M') {
				int x = readInt()+1, v = readInt();
				update(1, 1, N, x, v);
			} else {
				int l = readInt()+1, r = readInt()+1;
				System.out.println(query(1, 1, N, l, r));
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
	public static int query(int v, int l, int r, int tl, int tr) {
		if(tl>tr) return Integer.MAX_VALUE;
		if(l==tl && r==tr) {
			return seg[v];
		} else {
			int mid = (l+r)/2;
			return Math.min(query(v*2, l, mid, tl, Math.min(mid, tr)),query(v*2+1, mid+1, r, Math.max(tl, mid+1), tr));
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
