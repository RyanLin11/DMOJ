package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringFinding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String a = next();
		String b = next();
		char[] s = (b + "#"+ a).toCharArray();
		int[] z = new int[s.length];
		for(int i = 1, l = 0, r = 0; i<s.length; i++) {
			if(i<=r) {
				z[i] = Math.min(z[i-l], r-i+1);
			}
			while(i + z[i] < s.length && s[z[i]] == s[i+z[i]]) {
				z[i]++;
			}
			if(i + z[i] - 1> r) {
				l = i;
				r = i + z[i] - 1;
			}
		}
		for(int i = b.length()+1; i<z.length; i++) {
			if(z[i] == b.length()) {
				System.out.println(i-b.length()-1);
				return;
			}
		}
		System.out.println(-1);
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
