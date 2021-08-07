package vm7wc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestoringReputation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[]a,b;
	static int D, I, R;
	static int[][]dp;
	public static void main(String[] args) throws IOException {
		D = readInt(); I = readInt(); R = readInt();
		char[]a = next().toCharArray();
		char[]b = next().toCharArray();
		dp = new int[a.length+1][b.length+1];
		System.out.println(lcs(a,b,a.length,b.length));
	}
	public static int lcs(char[]a, char[]b, int x, int y) {
		if(x==0 && y==0) return 0;
		if(x>=1 && y>=1 && a[x-1]==b[y-1]) return dp[x][y] =lcs(a,b,x-1,y-1);
		if(dp[x][y]!=0) return dp[x][y];
		int min = Integer.MAX_VALUE;
		if(x>=1) min = Math.min(min, D+lcs(a,b,x-1,y));
		if(y>=1)  min = Math.min(min, I+lcs(a,b,x,y-1));
		if(x>=1 && y>=1) min = Math.min(min, R+lcs(a,b,x-1,y-1));
		return dp[x][y]=min;
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
