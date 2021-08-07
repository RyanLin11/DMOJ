package ccc07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Bowling {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			int k = readInt();
			int w = readInt();
			arr = new int[n];
			for(int j = 0; j<n; j++) {
				arr[j] = readInt();
			}
			int[][]dp = new int[n][k+1];
			Arrays.fill(dp[0],arr[0]);
			dp[0][0] = 0;
			for(int a = 1; a<dp.length; a++) {//expands the rightmost index
				for(int b = 1; b<dp[a].length; b++) {//iterates through bowling balls
					if(a-w<0) dp[a][b] = sum(0,a);
					else dp[a][b] = Math.max(dp[a-w][b-1]+sum(a-w+1, a), dp[a-1][b]);
				}
			}
			/*for(int a = 0; a<dp.length; a++) {
				for(int j = 0; j<dp[a].length; j++) {
					System.out.print(dp[a][j]+" ");
				}
				System.out.println();
			}*/
			System.out.println(dp[n-1][k]);
		}

	}
	public static int sum(int a, int b) {
		int sum = 0;
		for(int i = a; i<=b; i++) {
			sum+=arr[i];
		}
		return sum;
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
