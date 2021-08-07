package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CastleInvasion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]row = new int[N+1];
		for(int i = 0; i<N; i++) {
			row[i] = readInt();
		}
		row[N] = Integer.MAX_VALUE;
		Arrays.sort(row);
		int[]col = new int[N+1];
		for(int i = 0; i<N; i++) {
			col[i] = readInt();
		}
		col[N] = Integer.MAX_VALUE;
		Arrays.sort(col);
		long sum = 0;
		int r = N, c = N;
		int ri = 0, ci = 0;
		int prev = -1;
		int tmpr = 0, tmpc = 0;
		for(int i = 0; i<2*N; i++) {
			if(row[ri] <= col[ci]) {
				if(row[ri]!=prev) {
					r -= tmpr;
					c -= tmpc;
					tmpr = 0;
					tmpc = 0;
				}
				if(r==0) {
					System.out.println(-1);
					return;
				}
				sum += (r - tmpr) * (long)row[ri];
				prev = row[ri];
				ri++;
				tmpc++;
			} else {
				if(col[ci]!=prev) {
					r -= tmpr;
					c -= tmpc;
					tmpr = 0;
					tmpc = 0;
				}
				if(c==0) {
					System.out.println(-1);
					return;
				}
				sum += (c - tmpc) * (long)col[ci];
				prev = col[ci];
				ci++;
				tmpr++;
			}
		}
		System.out.println(sum);
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
