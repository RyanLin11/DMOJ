package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeleiAndDragonScales {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int W = readInt(), H = readInt(), N = readInt();
		int[][]arr = new int[H+1][W+1];
		for(int i = 1; i<arr.length; i++) {
			for(int j = 1; j<arr[i].length; j++) {
				arr[i][j] = readInt();
			}
		}
		for(int i = 1; i<arr.length; i++) {
			for(int j = 1; j<arr[i].length; j++) {
				arr[i][j] += arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
			}
		}
		int max = 0;
		for(int w = 1; w<=W; w++) {
			int h = N/w;
			int w1 = Math.min(w, W);
			int h1 = Math.min(h, H);
			for(int i = h1; i<arr.length; i++) {
				for(int j = w1; j<arr[i].length; j++) {
					max = Math.max(max, arr[i][j]-arr[i-h1][j]-arr[i][j-w1]+arr[i-h1][j-w1]);
				}
			}
		}
		System.out.println(max);
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
