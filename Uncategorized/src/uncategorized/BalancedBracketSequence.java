package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BalancedBracketSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[]arr;
	static int[][]dp;
	public static void main(String[] args) throws IOException {
		arr = readLine().toCharArray();
		dp = new int[arr.length][arr.length];
		for(int i = 0; i<dp.length; i++) Arrays.fill(dp[i], -1);
		System.out.println(f(0, arr.length-1));
	}
	public static int f(int l, int r) {
		if(l==r) return 1;
		else if(l>r) return 0;
		if(dp[l][r]!=-1) return dp[l][r];
		int min = Math.min(1+f(l+1, r), 1+f(l, r-1));
		if((arr[l]=='('&&arr[r]==')')||(arr[l]=='['&&arr[r]==']')) min = Math.min(min, f(l+1, r-1));
		for(int i = l; i<r; i++) {
			min = Math.min(min, f(l,i)+f(i+1,r));
		}
		return dp[l][r] = min;
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
