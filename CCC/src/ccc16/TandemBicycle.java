package ccc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class TandemBicycle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int q = readInt();
		int n = readInt();
		int[]arr1 = new int[n];
		int[]arr2 = new int[n];
		for(int i = 0; i<n; i++) {
			arr1[i] = readInt();
		}
		for(int i = 0; i<n; i++) {
			arr2[i] = readInt();
		}
		int sum = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(q==1) {
			for(int i = 0; i<n; i++) {
				sum+=Math.max(arr1[i], arr2[i]);
			}
		} else {
			for(int i = 0; i<n; i++) {
				sum+=Math.max(arr1[i], arr2[n-i-1]);
			}
		}
		System.out.println(sum);
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
