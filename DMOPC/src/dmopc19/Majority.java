package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Majority {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]bit;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		bit = new int[4*N+4];
		int t = 0; // threshold for accepting
		int shift = 2*N+2;
		long sum = 0;
		for(int i = 0; i<N; i++) {
			int x = readInt();
			if(x==1) {
				update(t+shift);
				t--;
				sum += query(bit.length-1) - query(t+shift);
			} else {
				update(t+shift);
				t++;
				sum += query(bit.length-1) - query(t+shift);
			}
		}
		System.out.println(sum);
	}
	public static void update(int x) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i]++;
		}
	}
	public static int query(int x) {
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
