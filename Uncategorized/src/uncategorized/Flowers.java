package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flowers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[]bit;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]h = new int[N];
		int[]a = new int[N];
		for(int i = 0; i<N; i++) h[i] = readInt();
		for(int i = 0; i<N; i++) a[i] = readInt();
		long ans = 0;
		bit = new long[N+1];
		for(int i = 0; i<N; i++) {
			long max = query(h[i])+a[i];
			ans = Math.max(ans, max);
			update(h[i], max);
		}
		System.out.println(ans);
	}
	public static void update(int x, long v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] = Math.max(bit[i], v);
		}
	}
	public static long query(int x) {
		long max = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			max = Math.max(max, bit[i]);
		}
		return max;
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
