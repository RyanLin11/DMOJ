package ccc21sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MathHomework {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]seg, arr;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		int[][]dif = new int[N+2][17];
		int[]x = new int[M];
		int[]y = new int[M];
		int[]z = new int[M];
		//range updates using difference array
		for(int i = 0; i<M; i++) {
			x[i] = readInt(); 
			y[i] = readInt(); 
			z[i] = readInt();
			dif[x[i]][z[i]]++;
			dif[y[i]+1][z[i]]--;
		}
		//prefix sum array
		for(int i = 1; i<dif.length; i++) {
			for(int j = 0; j<dif[i].length; j++) {
				dif[i][j] += dif[i-1][j];
			}
		}
		//LCM the thing
		arr = new int[N+1];
		Arrays.fill(arr, 1);
		for(int i = 1; i<arr.length; i++) {
			for(int j = 0; j<dif[i].length; j++) {
				if(dif[i][j] != 0) {
					arr[i] = lcm(arr[i], j);
				}
			}
		}
		//Segment Tree Range Queries
		seg = new int[4*N];
		Arrays.fill(seg, 1);
		for(int i = 1; i<arr.length; i++) {
			update(1, 1, N, i, arr[i]);
		}
		for(int i = 0; i<M; i++) {
			if(query(1, 1, N, x[i], y[i]) != z[i]) {
				System.out.println("Impossible");
				return;
			}
		}
		//print out the answer
		for(int i = 1; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void update(int v, int l, int r, int x, int val) {
		if(l == r) {
			seg[v] = arr[l];
		} else {
			int mid = (l+r)/2;
			if(x <= mid) update(v*2, l, mid, x, val);
			else update(v*2+1, mid+1, r, x, val);
			seg[v] = gcd(seg[v*2], seg[v*2+1]);
		}
	}
	public static int query(int v, int l, int r, int tl, int tr) {
		if(tl == l && tr == r) {
			return seg[v];
		} else {
			int mid = (l + r)/2;
			if(tr <= mid) return query(v*2, l, mid, tl, tr);
			else if(tl > mid) return query(v*2+1, mid+1, r, tl, tr);
			else return gcd(query(v*2, l, mid, tl, mid), query(v*2+1, mid+1, r, mid+1, tr));
		}
	}
	public static int lcm(int x, int y) {
		return x * y / gcd(x, y);
	}
	public static int gcd(int x, int y) {
		if(y == 0) return x;
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