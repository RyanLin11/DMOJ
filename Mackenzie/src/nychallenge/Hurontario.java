package nychallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hurontario {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String sa = next();
		String sb = next();
		char[]a = sa.toCharArray();
		char[]b = sb.toCharArray();
		long ha = 0;
		long hb = 0;
		//compute all powers
		long[]pow = new long[Math.max(a.length, b.length)];
		pow[0] = 1;
		for(int i = 1; i<pow.length; i++) {
			pow[i] = (pow[i-1]*131);
		}
		int index = -1;
		for(int i = 0; i<Math.min(a.length, b.length); i++) {
			ha = ((a[a.length-1-i]%64)+131*ha);
			hb = (hb + (b[i]%64)*pow[i]);
			if(ha==hb) {
				index = i;
			}
		}
		if(index==-1) System.out.println(sa+sb);
		else System.out.println(sa+sb.substring(index+1));
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
