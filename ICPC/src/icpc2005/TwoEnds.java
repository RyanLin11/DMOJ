package icpc2005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoEnds {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int game = 1;
		while(n!=0) {
			int[][]p1 = new int[n][n];
			int[][]p2 = new int[n][n];
			for(int i = 0; i<n; i++) {
				p1[i][i] = readInt();
				p2[i][i] = p1[i][i];
			}
			for(int i = 1; i<n; i++) {
				for(int j = i; j<n; j++) {
					p1[j-i][j] = Math.max(p1[j-i][j-i]-p2[j-i+1][j], p1[j][j]-p2[j-i][j-1]);
					if(p2[j-i][j-i]>=p2[j][j]) {
						p2[j-i][j] = p2[j-i][j-i]-p1[j-i+1][j];
					} else {
						p2[j-i][j] = p2[j][j]-p1[j-i][j-1];
					}
				}
			}
			System.out.println("In game "+game+", the greedy strategy might lose by as many as "+p1[0][n-1]+" points.");
			n = readInt(); game++;
		}

	}
	public static void print(int[][]dp) {
		for(int i = 0; i<dp.length; i++) {
			for(int j = 0; j<dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------");
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
