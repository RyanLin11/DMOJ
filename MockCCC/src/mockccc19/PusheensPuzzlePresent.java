package mockccc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PusheensPuzzlePresent {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		boolean mismatch  = false;
		boolean id = false;
		int left = 0;
		int a = 1;
		int ans = -1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int x = readInt();
				if(!id) {
					if(x!=a &&!mismatch) {
						left = j;
						mismatch = true;
					} else if(mismatch && x==a) {
						id = true;
						ans = j-left;
					}
				}
				a++;
			}
			if(!id && mismatch) {
				id = true;
				ans = n-left;
			}
		}
		System.out.println(ans);
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
