package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiverseSubarray {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]seg, dp;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		int[]arr = new int[N+1];
		int shift = (int)1e6;
		for(int i = 1; i<arr.length; i++) {
			arr[i] = readInt();
		}
		dp = new int[N+1];
		int[]lp = new int[2000001];
		int lft = 0;
		for(int i = 1; i<arr.length; i++) {
			lft = Math.max(lft, lp[arr[i]+shift]);
			lp[arr[i]+shift] = i;
			dp[i] = lft;
		}
		seg = new int[4*N];
		construct(1, 1, N);
		for(int i = 0; i<Q; i++) {
			int tl = readInt(), tr = readInt();
			int l = tl, r = tr;
			while(l <= r) {
				int mid = (l+r)/2;
				if(dp[mid] < tl) {
					l = mid+1;
				} else {
					r = mid-1;
				}
			}
			System.out.println(Math.max(l - tl, query(1, 1, N, l, tr)));
		}
	}
	public static void construct(int v, int l, int r) {
		if(l == r) {
			seg[v] = l - dp[l];
		} else {
			int mid = (l+r)/2;
			construct(v*2, l, mid);
			construct(v*2+1, mid+1, r);
			seg[v] = Math.max(seg[v*2], seg[v*2+1]);
		}
	}
	public static int query(int v, int l, int r, int tl, int tr) {
		if(tl>tr) return Integer.MIN_VALUE;
		if(tl == l && tr == r) {
			return seg[v];
		} else {
			int mid = (l+r)/2;
			return Math.max(query(v*2, l, mid, tl, Math.min(mid, tr)), query(v*2+1, mid+1, r, Math.max(tl, mid+1),tr));
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
