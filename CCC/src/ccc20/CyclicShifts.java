package ccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
//2h32 remaining
public class CyclicShifts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String t = next();
		String s = next();
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0; i<s.length(); i++) {
			if(t.contains(sb)) {
				System.out.println("yes");
				return;
			}
			char c = sb.charAt(0);
			sb.deleteCharAt(0);
			sb.append(c);
		}
		System.out.println("no");
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
