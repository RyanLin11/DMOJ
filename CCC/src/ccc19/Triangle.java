package ccc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]seg;
	static int[][]arr;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		arr = new int[n][n];
		seg = new int[2*n][2*n];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<=i; j++) {
				arr[i][j] = readInt();
			}
		}
		long sum = 0;
		for(int i = n-1; i>=0; i--) {
			for(int j = 0; j<n-i; j++) {
				updateHelper(i+j, j, arr[i+j][j]);
				if(j>=k-1) {
					//from (i+j,j) to (i+j-k+1, j-k+1)
					sum += queryHelper(i+j-k+1, i+j, j-k+1, j);
					//System.out.println("("+(i+j-k+1)+","+(j-k+1)+") to ("+(i+j)+","+j+") = "+x);
				}
			}
		}
		System.out.println(sum);
	}
	public static int queryHelper(int r1, int r2, int c1, int c2) {
		return query2d(r1, r2, c1, c2, 1, 0, arr.length-1);
	}
	public static void updateHelper(int r, int c, int val) {
		update2d(1, r, c, 0, arr.length-1, val);
	}
	public static int query2d(int r1, int r2, int c1, int c2, int v, int tl, int tr) {
		if(r1>r2 || v>=seg.length) {
			return 0;
		} else if(tl==r1 && tr==r2) {
			return query1d(v, c1, c2, 1, 0, arr[0].length-1);
		} else {
			int mid = (tl+tr)/2;
			return Math.max(query2d(r1, Math.min(mid, r2), c1, c2, v+1, tl, mid), query2d(Math.max(mid+1, r1),r2, c1, c2, v+2*(mid-tl+1), mid+1, tr));
		}
	}
	public static int query1d(int r, int c1, int c2, int v, int tl, int tr) {
		if(c1>c2 || v>=seg[c1].length) {
			return 0;
		} else if(tl==c1 && tr==c2) {
			return seg[r][v];
		} else {
			int mid = (tl+tr)/2;
			return Math.max(query1d(r, c1, Math.min(mid, c2), v+1, tl, mid), query1d(r, Math.max(mid+1, c1), c2, v+2*(mid-tl+1), mid+1, tr));
		}
	}
	public static void update2d(int v, int r, int c, int tl, int tr, int val) {
		if(v>=seg.length) {
			return;
		} else if(tl==r && tr==r) {
			update1d(1, v, c, 0, arr[0].length-1, val);
		} else {
			int mid = (tl+tr)/2;
			if(r<=mid) {
				update2d(v+1, r, c, tl, mid, val);
			} else {
				update2d(v+2*(mid-tl+1), r, c, mid+1, tr, val);
			}
			update1d(1, v, c, 0, arr[0].length-1, Math.max(query1d(v+1,c,c,1,0,arr[0].length-1), query1d(v+2*(mid-tl+1),c,c,1,0,arr[0].length-1)));
		}
	}
	public static void update1d(int v, int r, int c, int tl, int tr, int val) {
		if(v>=seg[0].length) {
			return;
		} else if(tl==c && tr==c) {
			seg[r][v] = val;
		} else {
			int mid = (tl+tr)/2;
			if(c<=mid) {
				update1d(v+1, r, c, tl, mid, val);
			} else {
				update1d(v+2*(mid-tl+1), r, c, mid+1, tr, val);
			}
			seg[r][v] = Math.max(seg[r][v+1], seg[r][v+2*(mid-tl+1)]);
		}
	}
	public static void print(int[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
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
