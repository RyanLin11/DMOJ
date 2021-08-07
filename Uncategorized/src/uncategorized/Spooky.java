package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Spooky {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
		int x, v;
		public Pair(int x, int v) {
			this.x = x;
			this.v = v;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.x, other.x);
		}
	}
	public static void main(String[] args) throws IOException {
		int M = readInt(), N = readInt(), S = readInt();
		ArrayList<Pair>pt = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			int l = readInt(), r = readInt(), s = readInt();
			pt.add(new Pair(l, s));
			pt.add(new Pair(r+1, -s));
		}
		pt.add(new Pair(N+1, 0));
		Collections.sort(pt);
		int sum = 0;
		int prev = 1;
		int ans = 0;
		for(Pair p: pt) {
			if(sum<S) ans += p.x - prev;
			sum += p.v;
			prev = p.x;
		}
		System.out.println(ans);
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
