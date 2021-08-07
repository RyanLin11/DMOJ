package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sushi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static double[][][]dp;
	static int n;
	public static void main(String[]args) throws IOException {
		n = readInt();
		int[]freq = new int[3];
		for(int i = 0; i<n; i++) {
			freq[readInt()-1]++;
		}
		dp = new double[n+1][n+1][n+1];
		System.out.println(f(freq[2],freq[1],freq[0]));
	}
	public static double f(int a, int b, int c) {
		if(a==0 &&b==0 && c==0) return 0;
		if(dp[a][b][c]!=0) return dp[a][b][c];
		double ans = 0;
		if(a!=0) ans+=(a/(double)(a+b+c))*(n/(double)(a+b+c)+f(a-1,b+1,c));
		if(b!=0) ans+=(b/(double)(a+b+c))*(n/(double)(a+b+c)+f(a,b-1,c+1));
		if(c!=0) ans+=(c/(double)(a+b+c))*(n/(double)(a+b+c)+f(a,b,c-1)); 
		return dp[a][b][c]=ans;
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
