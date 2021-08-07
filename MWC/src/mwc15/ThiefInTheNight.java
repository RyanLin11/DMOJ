package mwc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThiefInTheNight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int f = readInt(), r = readInt();
		int[][]pre = new int[f][r+1];
		for(int i = 0; i<f; i++) {
			for(int j = 1; j<=r; j++) {
				pre[i][j] = pre[i][j-1]+readInt();
			}
		}
		int q = readInt();
		for(int i = 0; i<q; i++) {
			int lf = readInt(), rt = readInt(), fl = readInt()-1;
			System.out.println(pre[fl][rt]-pre[fl][lf-1]);
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
