package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Fix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			ArrayList<String>list = new ArrayList<>();
			boolean free = true;
			for(int j = 0; j<3; j++) {
				String s = next();
				for(String t: list) {
					if(t.length()<=s.length()) {
						if(s.substring(0,t.length()).equals(t) || s.substring(s.length()-t.length(), s.length()).equals(t)) {
							free = false;
							break;
						}
					} else {
						if(t.substring(0, s.length()).equals(s) || t.substring(t.length()-s.length(), t.length()).equals(s)) {
							free = false;
							break;
						}
					}
				}
				list.add(s);
			}
			System.out.println(free?"Yes":"No");
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
