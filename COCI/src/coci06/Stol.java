package coci06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stol {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int R = readInt(), C = readInt();
		int[][]psa = new int[R][C+1];
		for(int i = 0; i<psa.length; i++) {
			char[]c = next().toCharArray();
			for(int j = 1; j<psa[i].length; j++) {
				psa[i][j] += psa[i][j-1];
				if(c[j-1]=='X') psa[i][j]++;
			}
		}
		int gmax = 0;
		for(int i = 1; i<C+1; i++) {
			for(int j = i; j<C+1; j++) {
				int cnt = 0, max = 0;
				for(int k = 0; k<psa.length; k++) {
					if(psa[k][j]-psa[k][i-1]==0) {
						cnt++;
					} else {
						max = Math.max(max, cnt);
						cnt = 0;
					}
				}
				max = Math.max(max, cnt);
				if(max!=0) gmax = Math.max(gmax, 2*(j-i+1) + 2*max);
			}
		}
		System.out.println(gmax-1);
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
