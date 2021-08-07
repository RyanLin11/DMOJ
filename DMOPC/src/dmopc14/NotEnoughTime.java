package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotEnoughTime {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int w = readInt();
		int[] arr1 = new int[w+1];
		int[] arr2 = new int[w+1];
		int[][]wt = new int[3][n+1];
		int[][]val = new int[3][n+1];
		for(int i = 1; i<n+1; i++) {
			for(int j = 0; j<3; j++) {
				wt[j][i] = readInt();
				val[j][i] = readInt();
			}
		}
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<arr1.length; j++) {
				int max = 0;
				for(int k = 0; k<3; k++) {
					if(j-wt[k][i]>=0) {
						max = Math.max(max, val[k][i]+arr1[j-wt[k][i]]);
					}
				}
				arr2[j] = Math.max(max, arr1[j]);
			}
			arr1 = arr2;
			arr2 = new int[w+1];
		}
		System.out.println(arr1[arr1.length-1]);
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
