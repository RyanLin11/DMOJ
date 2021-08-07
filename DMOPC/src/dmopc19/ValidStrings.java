package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ValidStrings {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[]arr;
	static boolean[][]dp;
	static boolean[][]vis;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			String s = next();
			arr = new char[s.length()]; int cnt = 0;
			for(int j = 0; j<s.length(); j++) {
				if(!Character.isDigit(s.charAt(j))) {
					arr[cnt] = s.charAt(j);cnt++;
				}
			}
			dp = new boolean[cnt][cnt];
			vis = new boolean[cnt][cnt];
			System.out.println(f(0,cnt-1)?"YES":"NO");
		}
	}
	public static boolean f(int l, int r) {
		if(l>r) return true;
		if(l==r) return Character.isDigit(arr[l]);
		if(vis[l][r]) return dp[l][r];
		vis[l][r] = true;
		if(arr[l]=='('&&f(l+1, r-1)&&arr[r]==')') return dp[l][r]= true;
		for(int i = l; i<r; i++) {
			if(f(l,i)&&f(i+1,r)) return dp[l][r]= true;
		}
		return dp[l][r] = false;
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
