package ccc11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class EnglishOrFrench {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder("");
		int n = readInt();
		for(int i = 0; i<n; i++) {
			sb.append(readLine());
		}
		String str = sb.toString().toUpperCase();
		int t = 0;
		int a = str.indexOf("T");
		while(a>=0) {
			t++;
			a = str.indexOf("T",a+1);
		}
		int s = 0;
		a = str.indexOf("S");
		while(a>=0) {
			s++;
			a = str.indexOf("S",a+1);
			
		}
		if(t>s) System.out.println("English");
		else System.out.println("French");
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
