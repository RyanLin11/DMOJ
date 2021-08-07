package ccc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sunflowers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][]arr1 = new int[n][n];
		int[][]arr2 = new int[n][n];
		int[][]arr3 = new int[n][n];
		int[][]arr4 = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr1[i][j] = readInt();
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				arr2[i][j] = arr1[n-j-1][i];
				arr3[i][j] = arr1[n-i-1][n-j-1];
				arr4[i][j] = arr1[j][n-i-1];
			}
		}
		check(arr1);
		check(arr2);
		check(arr3);
		check(arr4);
	}
	public static boolean check(int[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			int max = 0;
			int maxcol = 0;
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j]<max) {
					return false;
				}
				max = arr[i][j];
				if(arr[j][i]<maxcol) {
					return false;
				}
				maxcol = arr[j][i];
			}
		}
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		return true;
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
