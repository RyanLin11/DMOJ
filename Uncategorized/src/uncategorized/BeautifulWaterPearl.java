package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeautifulWaterPearl {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int c = readInt(), d = readInt(), e = readInt();
		//if digit in c is 0, digit in a and b must be zero
		//if digit in d is 1, digit in a and b must be one
		//if digit in e is 1, digit in a and b must be different
		int cnt = 1;
		for(int i = 0; i<30; i++) {
			int c1 = c>>i&1, d1 = d>>i&1, e1 = e>>i&1;
			if(c1==0 && d1==1 ||(c1==0 && e==1)||(d1==1 && e1==1)) {
				System.out.println(0); return;
			}
			if(e1==1) {
				cnt*=2;
			}
		}
		System.out.println(cnt);
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
