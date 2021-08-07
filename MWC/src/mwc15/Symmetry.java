package mwc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Symmetry {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]c = next().toCharArray();
		String s = "";
		for(int i = 0; i<c.length; i++) {
			for(int j = 0; j<i+1; j++) {
				s+=c[i];
			}
		}
		for(int i = c.length-2; i>=0; i--) {
			for(int j = 0; j<i+1; j++) s+=c[i];
		}
		ArrayList<String>list = new ArrayList<>();
		list.add(s);
		char[]x = s.toCharArray();
		for(int i = 0; i<x.length/2; i++) {
			x[i+1] = s.charAt(0);
			x[x.length-i-2] = s.charAt(0);
			String t = "";
			for(int j = 0; j<x.length; j++) {
				t+=x[j];
			}
			list.add(t);
		}
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(int i = list.size()-2; i>=0; i--) {
			System.out.println(list.get(i));
		}
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
