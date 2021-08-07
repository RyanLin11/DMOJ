package globexcup19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessMasterWinnie {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), a = readInt(), b = readInt(), c = readInt();
		int[]record = new int[n+1];
		for(int i = 1; i<=n; i++) {
			record[i] = readInt();
		}
		for(int i = 0; i<c; i++) {
			int flag = record[readInt()];
			if(flag==1) {
				m+=a;
			} else if(flag==0) {
				m-=b;
			}
		}
		System.out.println(m);
	}
	public static String next () throws IOException {
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
