package coci18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cipele {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr1, arr2;
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		arr1 = new int[N];
		arr2 = new int[M];
		for(int i = 0; i<N; i++) {
			arr1[i] = readInt();
		}
		for(int i = 0; i<M; i++) {
			arr2[i] = readInt();
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(arr1.length > arr2.length) {
			int[]tmp = arr1;
			arr1 = arr2;
			arr2 = tmp;
		}
		int l = 0, r = (int)1e9;
		int ans = 0;
		while(l <= r) {
			int mid = (l+r)/2;
			if(f(mid)) {
				ans = mid;
				r = mid-1;
			} else {
				l = mid+1;
			}
		}
		System.out.println(ans);
	}
	public static boolean f(int dis) {
		int idx = 0;
		for(int i = 0; i<arr2.length && idx < arr1.length; i++) {
			if(Math.abs(arr1[idx] - arr2[i]) <= dis) {
				idx++;
			}
		}
		return idx == arr1.length;
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
