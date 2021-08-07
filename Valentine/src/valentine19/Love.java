package valentine19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Love {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]c = next().toCharArray();
		long l = 0, o = 0, v = 0, e = 0;
		for(int i = 0; i<c.length; i++) {
			if(c[i]=='l') {
				l++;
			} else if(c[i]=='o') {
				o+=l;
			} else if(c[i]=='v') {
				v+=o;
			} else if(c[i]=='e') {
				e+=v;
			}
		}
		System.out.println(e);
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
