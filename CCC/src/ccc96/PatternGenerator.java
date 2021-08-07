package ccc96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class PatternGenerator {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashSet<Long>set;
	public static void main(String[] args) throws IOException {
		int q = readInt();
		set = new HashSet<>();
		for(int i = 0; i<q; i++) {
			int n = readInt();
			int k = readInt();
			System.out.println("The bit patterns are");
			f(n, k, "");
			System.out.println();
		}
	}
	public static void f(int n, int k, String s) {
		if(n==0) {
			if(k==0 && !set.contains(Long.parseLong(s,2))) {
				System.out.println(s);
				set.add(Long.parseLong(s,2));
			}
			return;
		}
		if(k>0) f(n-1, k-1, s+"1");
		f(n-1,k,s+"0");
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
