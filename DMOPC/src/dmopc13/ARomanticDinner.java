package dmopc13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARomanticDinner {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m,u,r;
	static int[] val;
	static int[] time;
	static int[] food;
	public static void main(String[] args) throws IOException {
		m = readInt();
		u = readInt();
		r = readInt();
		val = new int[r];
		time = new int[r];
		food = new int[r];
		for(int i = 0; i<r; i++) {
			val[i] = readInt();
			time[i] = readInt();
			food[i] = readInt();
		}
		System.out.println(f(0,m,0,u));
	}
	public static int f(int d, int m, int v, int f) {
		if(d==r) return v;
		if(f-food[d]<0 || m-time[d]<0) return f(d+1,m,v,f);
		return Math.max(f(d+1,m,v,f),f(d+1,m-time[d],v+val[d],f-food[d]));
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
