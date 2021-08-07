package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MockingSpongebob {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		for(int i = 0; i<N; i++) {
			char[]c = readLine().toCharArray();
			boolean lower = true;
			for(int j = 0; j<c.length; j++) {
				if(!Character.isLetter(c[j])) {
					System.out.print(c[j]);
				} else {
					if(lower) System.out.print(Character.toLowerCase(c[j]));
					else System.out.print(Character.toUpperCase(c[j]));
					lower = !lower;
				}
			}
			System.out.println();
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
