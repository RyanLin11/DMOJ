package dwite10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EscapeAndLoot {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<5; i++) {
			char[][]c = new char[8][8];
			for(int j = 0; j<8; j++) {
				c[j] = next().toCharArray();
			}
			int[][]dp = new int[9][8];
			for(int j = 7; j>=0; j--) {
				if(c[j][0]=='.')dp[j][0]=dp[j+1][0];
				else if(Character.isDigit(c[j][0]))dp[j][0] = Integer.parseInt(c[j][0]+"")+dp[j+1][0] ;
				for(int k = 1; k<8; k++) {
					if(c[j][k]=='.')dp[j][k] = Math.max(dp[j+1][k],dp[j][k-1]);
					else if(Character.isDigit(c[j][k]))dp[j][k] = Integer.parseInt(c[j][k]+"")+Math.max(dp[j+1][k],dp[j][k-1]);
				}
			}
			System.out.println(dp[0][7]);
			if(i!=4) {
				String str = next();
			}
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
