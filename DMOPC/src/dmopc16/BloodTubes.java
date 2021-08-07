package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BloodTubes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]bit = new int[N+1];
		long inv = 0;
		for(int i = 0; i<N; i++) {
			int x = readInt();
			int above = sum(bit, N) - sum(bit, x);
			int below = sum(bit, x-1);
			inv += Math.min(above, below);
			update(bit, x, 1);
		}
		System.out.println(inv);
	}
	public static int sum(int[]bit, int x) {
		int sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
	}
	public static void update(int[]bit, int x, int val) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] += val;
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
