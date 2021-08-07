package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RogersStarMap {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]bit = new int[32002];
		int[]lvl = new int[N];
		for(int i = 0; i<N; i++) {
			int x = readInt(), y = readInt();
			lvl[query(bit, x+1)]++;
			update(bit, x+1);
		}
		for(int i = 0; i<lvl.length; i++) {
			System.out.println(lvl[i]);
		}
	}
	public static void update(int[]bit, int index) {
		for(int i = index; i<bit.length; i+=i&(-i)) {
			bit[i]++;
		}
	}
	public static int query(int[]bit, int index) {
		int sum = 0;
		for(int i = index; i>0; i-=i&(-i)) {
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
