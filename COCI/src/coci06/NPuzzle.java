package coci06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NPuzzle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int dis = 0;
		for(int i = 0; i<4; i++) {
			char[]c = next().toCharArray();
			for(int j = 0; j<4; j++) {
				if(c[j]!='.' && c[j]!=(char)('A'+i*4+j)) {
					dis+=Math.abs((c[j]-'A')%4-j)+Math.abs((c[j]-'A')/4-i);
				}
			}
		}
		System.out.println(dis);
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
