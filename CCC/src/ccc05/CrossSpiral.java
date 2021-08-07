package ccc05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CrossSpiral {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r, c, k;
	static int[][]arr;
	static boolean[][]vis;
	static int step, cnt;
	public static void main(String[] args) throws IOException {
		int W = readInt(), H = readInt(), w = readInt(), h = readInt();
		step = readInt();
		arr = new int[H+2][W+2];
		//filling the array with initial distances
		for(int i = 1; i<=h; i++) {
			for(int j = 1; j<=w; j++) {
				arr[i][j] = 1;
			}
		}
		for(int i = 1; i<=h; i++) {
			for(int j = W-w+1; j<=W; j++) {
				arr[i][j] = 1;
			}
		}
		for(int i = H-h+1; i<=H; i++) {
			for(int j = 1; j<=w; j++) {
				arr[i][j] = 1;
			}
		}
		for(int i = H-h+1; i<=H; i++) {
			for(int j = W-w+1; j<=W; j++) {
				arr[i][j] = 1;
			}
		}
		for(int j = 0; j<arr[0].length; j++) {
			arr[0][j] = 1;
		}
		for(int j = 0; j<arr[0].length; j++) {
			arr[H+1][j] = 1;
		}
		for(int i = 0; i<arr.length; i++) {
			arr[i][0] = 1;
		}
		for(int i = 0; i<arr.length; i++) {
			arr[i][W+1] = 1;
		}
		//iterative filling out table (at most max(H, W)/2 steps)
		int[][] dir = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}};
		for(int k = 1; k<=Math.max(H, W)+1; k++) {
			for(int i = 1; i<=H; i++) {
				for(int j = 1; j<=W; j++) {
					if(arr[i][j] == 0) {
						for(int m = 0; m<dir.length; m++) {
							if(arr[i+dir[m][0]][j+dir[m][1]] == k) {
								arr[i][j] = k+1;
							}
						}
					}
				}
			}
		}
		//print(arr);
		//trace steps (L D L D R D L U R U R U)
		vis = new boolean[H+2][W+2];
		r = 1;
		c = w+1;
		k = 2;
		cnt = 0;
		while(k <= Math.max(H, W)+1) {
			go();
		}
		System.out.println(c);
		System.out.println(r);
	}
	public static void go() {
		if(arr[r][c+1] == k && !vis[r][c+1] && cnt < step) {
			vis[r][c] = true;
			cnt++;
			c++;
		} else if(arr[r+1][c] == k && !vis[r+1][c] && cnt < step) {
			vis[r][c] = true;
			cnt++;
			r++;
		} else if(arr[r][c-1] == k && !vis[r][c-1] && cnt < step) {
			vis[r][c] = true;
			cnt++;
			c--;
		} else if(arr[r-1][c] == k && !vis[r-1][c] && cnt < step) {
			vis[r][c] = true;
			cnt++;
			r--;
		} else {
			k++;
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
