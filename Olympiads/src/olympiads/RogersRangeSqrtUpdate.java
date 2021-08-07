package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.HashSet;

public class RogersRangeSqrtUpdate {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[]bit, arr;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		bit = new long[N+1];
		arr = new long[N+1];
		TreeSet<Integer>set = new TreeSet<>();
		for(int i = 1; i<bit.length; i++) {
			update(i, readLong());
			set.add(i);
		}
		int M = readInt();
		for(int i = 0; i<M; i++) {
			int d = readInt(), l = readInt(), r = readInt();
			if(d == 1) {
				System.out.println(sum(r) - sum(l-1));
			} else {
				try {
					//Integer from = set.ceiling(l);
					//Integer to = set.floor(r);
					HashSet<Integer>s = new HashSet<>();
					for(int x: set.subSet(l, r+1)) {
						update(x, (long)Math.floor(Math.sqrt(arr[x])));
						if(arr[x] <= 1) s.add(x);
					}
					for(int x: s) {
						set.remove(x);
					}
				} catch (NullPointerException e) {}
			}
		}
	}
	public static long sum(int x) {
		long sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
	}
	public static void update(int x, long v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] += v - arr[x];
		}
		arr[x] = v;
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
