package ccchk15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueensCantAttackMe {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		boolean[][] board = new boolean[n][n];
		for(int i = 0; i<m; i++) {
			int x = readInt()-1;
			int y = readInt()-1;
			for(int j = 0; j<n; j++) {
				board[x][j] = true;
				board[j][y] = true;
			}
			for(int j = x, k=y; j>=0 && k<n; j--, k++) board[j][k] = true;
			for(int j = x, k=y; j>=0 && k>=0; j--,k--) board[j][k] = true;
			for(int j = x, k=y; j<n && k<n; j++, k++) board[j][k] = true;
			for(int j = x, k=y; j<n && k>=0; j++, k--) board[j][k] = true;
		}
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(board[i][j]==false) {
					count++;
				}
			}
		}
		System.out.println(count);
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
