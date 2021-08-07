package ccchk08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestFish {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int c = readInt();
		int cs = 0;
		for(int i = 0; i<c; i++) {
			cs = Math.max(cs, readInt()*readInt());
		}
		int n = readInt();
		int ns = 0;
		for(int i = 0; i<n; i++) {
			ns = Math.max(ns, readInt()*readInt());
		}
		if(cs>ns) System.out.println("Casper");
		else if(cs<ns) System.out.println("Natalie");
		else System.out.println("Tie");
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
