package fhc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WinningAtSports {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][]dp1, dp2;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 1; i<=T; i++) {
			String s = next();
			int x = Integer.parseInt(s.substring(0, s.indexOf("-")));
			int y = Integer.parseInt(s.substring(s.indexOf("-")+1));
			dp1 = new long[x+1][y+1];
			dp2 = new long[x+1][y+1];
			System.out.println("Case #"+i+": "+stressfree(x,y)+" "+stressful(x,y));
		}
	}
	public static long stressfree(int x, int y) {
		if(dp1[x][y] != 0) return dp1[x][y];
		if(x==1 && y==0) {
			return 1;
		}
		if(x > y+1 && x > 0) {
			dp1[x][y] += stressfree(x-1, y);
		}
		if(y > 0) {
			dp1[x][y] += stressfree(x, y-1);
		}
		dp1[x][y] %= mod;
		return dp1[x][y];
	}
	public static long stressful(int x, int y) {
		if(dp2[x][y] != 0) return dp2[x][y];
		if(x==0 && y==0) {
			return 1;
		}
		if(y > x && y > 0) {
			dp2[x][y] += stressful(x, y-1);
		}
		if(x > 0) {
			dp2[x][y] += stressful(x-1, y);
		}
		dp2[x][y] %= mod;
		return dp2[x][y];
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
