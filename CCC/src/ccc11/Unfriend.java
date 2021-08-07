package ccc11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Unfriend {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		list = new ArrayList[N+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 1; i<N; i++) {
			int x = readInt();
			list[x].add(i);
		}
		System.out.println(f(N));
	}
	public static long f(int u) {
		long x = 1;
		for(int v: list[u]) {
			x *= (f(v)+1);
		}
		return x;
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
