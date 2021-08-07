package ccc09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OldFishinHole {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt();
		int b = readInt();
		int c = readInt();
		int max = readInt();
		int count = 0;
		for(int i = 0; i<=(max/a); i++) {
			for(int j = 0; j<=(max/b); j++) {
				for(int k = 0; k<=(max/c); k++) {
					if(i+j+k>=1 && i*a+j*b+k*c<=max) {
						System.out.println(i+" Brown Trout, "+j+" Northern Pike, "+k+" Yellow Pickerel");
						count++;
					}
				}
			}
		}
		System.out.println("Number of ways to catch fish: "+count);
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
