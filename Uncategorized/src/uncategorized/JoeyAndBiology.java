package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JoeyAndBiology {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static char[]c,d;
	static int[][]dp;
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		c = next().toCharArray();
		d = next().toCharArray();
		dp = new int[n+1][m+1];
		System.out.println(lcs(n,m));
	}
	public static int lcs(int x, int y) {
		if(x<0||y<0) return Integer.MAX_VALUE;
		if(x==0&&y==0) return dp[x][y]=0;
		if(x>=1 && y>=1 && c[x-1]==d[y-1]) return dp[x][y] = lcs(x-1,y-1);
		if(dp[x][y]!=0) return dp[x][y];
		int min = Integer.MAX_VALUE;
		if(x>=1) min = Math.min(min, 1+lcs(x-1,y));
		if(x>=2) min = Math.min(min, 1+lcs(x-2,y));
		if(x>=3) min = Math.min(min, 1+lcs(x-3,y));
		if(y>=1) min = Math.min(min, 1+lcs(x,y-1));
		if(y>=2) min = Math.min(min, 1+lcs(x,y-2));
		if(y>=3) min = Math.min(min, 1+lcs(x,y-3));
		if(x>=1 && y>=1) min = Math.min(min, 1+lcs(x-1,y-1));
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
