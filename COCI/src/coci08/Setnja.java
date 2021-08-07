package coci08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Setnja {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]c = next().toCharArray();
		BigInteger n = new BigInteger("1");
		BigInteger active = new BigInteger("1");
		BigInteger TWO = new BigInteger("2");
		BigInteger THREE = new BigInteger("3");
		BigInteger FIVE = new BigInteger("5");
		for(int i = 0; i<c.length; i++) {
			if(c[i]=='L') {
				n=n.multiply(TWO);
			} else if(c[i]=='R') {
				n=n.multiply(TWO).add(active);
			} else if(c[i]=='*') {
				n=n.multiply(FIVE).add(active);
				active=active.multiply(THREE);
			}
		}
		System.out.println(n.toString());
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
