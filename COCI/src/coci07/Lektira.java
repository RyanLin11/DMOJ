package coci07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Lektira {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = next();
		int N = s.length();
		ArrayList<String>list = new ArrayList<>();
		for(int i = 1; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				String a = new StringBuilder(s.substring(0,i)).reverse().toString();
				String b = new StringBuilder(s.substring(i,j)).reverse().toString();
				String c = new StringBuilder(s.substring(j,N)).reverse().toString();
				list.add(a+b+c);
				
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
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
