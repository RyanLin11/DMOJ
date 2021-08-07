package globexcup18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicalFunctions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long a, b, c, d, e;
	public static void main(String[] args) throws IOException {
		a = readLong();
		b = readLong();
		c = readLong();
		d = readLong();
		e = readLong();
		long N = readLong();
		System.out.println(f(N));
	}
	public static long f(long x) {
		if(x==0) return e;
		return (a*f(x/b)+c*f(x/d))%1000000007;
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
