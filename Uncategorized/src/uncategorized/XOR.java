package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XOR {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int s = readInt()-1, f = readInt(), res = 0;
			for(int j = 1; j<=30; j++) {
				int k = 1<<j;
				int s1 = (k/2)*((s+1)/k)+Math.max(0, (s+1)%k-(k/2));
				int f1 = (k/2)*((f+1)/k)+Math.max(0, (f+1)%k-(k/2));
				if((f1-s1)%2==1) res=res|(1<<(j-1));
			}
			System.out.println(res);
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
