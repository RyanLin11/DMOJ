package dmopc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quests {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int H = readInt();
		long[]dp1 = new long[H+1];
		long[]dp2 = new long[H+1];
		for(int i = 0; i<n; i++) {
			int g = readInt();
			int h = readInt();
			int v = readInt();
			int t = readInt();
			for(int j = 0; j<dp2.length; j++) {
				if(j-h>=0) {
					dp2[j] = dp1[j-h]+g;
					if(j-h-t>=0) dp2[j] = Math.max(dp2[j],dp2[j-t]+v);
				}
			}
			for(int j = 0; j<dp1.length; j++) {
				dp1[j] = Math.max(dp1[j], dp2[j]);
			}
			dp2 = new long[H+1];
		}
		System.out.println(dp1[H]);
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
