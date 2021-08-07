package ccc21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(next());
		int[]arr = new int[N+1];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(next());
		}
		int[]w = new int[N];
		for(int i = 0; i<w.length; i++) {
			w[i] = Integer.parseInt(next());
		}
		double cnt = 0;
		for(int i = 1; i<arr.length; i++) {
			int min = Math.min(arr[i], arr[i-1]);
			int max = Math.max(arr[i], arr[i-1]);
			cnt += min * w[i-1];
			cnt += ((max - min) / 2.0) * w[i-1];
		}
		System.out.println(cnt);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}
