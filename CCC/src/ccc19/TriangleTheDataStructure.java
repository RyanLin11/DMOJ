package ccc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TriangleTheDataStructure {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]arr;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<=i; j++) {
				arr[i][j] = readInt();
			}
		}
		calculateMax(k);
		long sum = 0;
		for(int i = 0; i<=n-k; i++) {
			for(int j = 0; j<=i; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
	public static void calculateMax(int k) {
		int size = 0;
		if(k==1) return;
		else if(k==2) size = 1;
		else size = (int)Math.ceil(2*k/3.0);
		calculateMax(size);
		for(int i = 0; i<=arr.length-k; i++) {
			for(int j = 0; j<=i; j++) {
				arr[i][j] = Math.max(arr[i][j], Math.max(arr[i+k-size][j], arr[i+k-size][j+k-size]));
			}
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
