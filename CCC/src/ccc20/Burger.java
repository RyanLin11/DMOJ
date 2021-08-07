package ccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Burger {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr, last;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		arr = new int[N];
		last = new int[5001];
		Arrays.fill(last, -1);
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		for(int i = N-1; i>=0; i--) {
			if(last[arr[i]] < 0) {
				last[arr[i]] = i;
			}
		}
		double ans = 0;
		for(int i = 0; i<arr.length; i++) {
			ans += (1.0/arr.length)*f(i);
		}
		System.out.println(ans);
	}
	public static double f(int in) {
		//coach's burger is taken
		if(arr[in] == arr[0]) {
			return 1;
		}
		//josh's burger is displaced
		if(last[arr[in]] == arr.length-1) {
			return 0;
		}
		double p = 0;
		int burgersLeft = arr.length - last[arr[in]];
		for(int i = last[arr[in]]+1; i<arr.length; i++) {
			p += (1.0 /burgersLeft) * f(i);
		}
		//the probability that the coach's burger is taken
		p += (1.0/burgersLeft);
		return p;
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
