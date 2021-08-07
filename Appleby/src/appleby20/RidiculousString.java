package appleby20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RidiculousString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = readInt(), b = readInt();
		char[]s = next().toCharArray();
		char[]t = next().toCharArray();
		int[][]dp = new int[s.length][26];
		//fill the first row with nonsense
		for(int j = 0; j<26; j++) {
			dp[s.length-1][j] = -1;
		}
		for(int i = s.length-1; i>=0; i--) {
			int c = s[i] - 97;
			for(int j = 0; j<26; j++) {
				if(j == c) {
					dp[(i-1+s.length) % s.length][j] = i;
				} else {
					dp[(i-1+s.length) % s.length][j] = dp[i][j];
				}
			}
		}
		//fill in the back
		for(int i = s.length-2; i>=0; i--) {
			for(int j = 0; j<26; j++) {
				if(dp[i][j] < 0) {
					dp[i][j] = dp[i+1][j];
				}
			}
		}
		//do the algorithm
		int prev = dp[s.length-1][t[0]-97];
		if(prev == -1) {
			System.out.println(-1);
			return;
		}
		int cnt = 0;
		for(int i = 1; i<t.length; i++) {
			int c = t[i] - 97;
			int pos = dp[prev][c];
			if(pos == -1) {
				System.out.println(-1);
				return;
			} else if(pos <= prev) {
				cnt++;
			}
			prev = pos;
		}
		long ans = (long)cnt*s.length + (long)(prev+1);
		System.out.println(ans);
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
