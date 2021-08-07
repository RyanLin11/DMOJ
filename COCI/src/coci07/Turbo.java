package coci07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turbo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]bit = new int[N+1];
		int[]bit2 = new int[N+1];
		int[]arr = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[readInt()] = i;
		}
		for(int i = 0, l = 1, r = N; l<=r; i++) {
			if(i%2==0) { //increase left
				System.out.println(arr[l] - l + query(bit, N) - query(bit, arr[l]) - query(bit2, arr[l]));
				update(bit, arr[l]);
				l++;
			} else { //decrease right
				System.out.println(r - arr[r] - query(bit, N) + query(bit, arr[r]) + query(bit2, arr[r]));
				update(bit2, arr[r]);
				r--;
			}
		}
	}
	public static void update(int[]bit, int x) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i]++;
		}
	}
	public static int query(int[]bit, int x) {
		int sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
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
