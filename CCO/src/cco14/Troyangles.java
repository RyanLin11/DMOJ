package cco14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Troyangles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][]arr;
	static int[][]dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		arr = new char[n][n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = next().toCharArray();
		}
		dp = new int[n][n];
		long sum = 0;
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j]=='#') {
					if(dp[i][j]==0) {
						sum+=recur(i,j);
					} else {
						sum+=dp[i][j];
					}
				}
			}
		}
		System.out.println(sum);
	} 
	public static int recur(int r, int c) {
		if(r<0 || c<0 || r>=dp.length || c>=dp.length || arr[r][c]=='.') return 0;
		if(dp[r][c]!=0) return dp[r][c];
		return dp[r][c] = 1+Math.min(recur(r+1,c-1),Math.min(recur(r+1, c), recur(r+1,c+1)));
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
