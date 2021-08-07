package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShoeShopping {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]arr = new int[n];
		for(int i = 0; i<n; i++) arr[i] = readInt();
		double[]dp = new double[n];
		dp[0] = arr[0];
		if(n>=2)dp[1] = arr[0]+arr[1]-(0.5*Math.min(arr[0], arr[1]));
		if(n>=3)dp[2] = Math.min(Math.min(arr[0]+arr[1]+arr[2]-Math.min(arr[0], Math.min(arr[1], arr[2])), arr[1]+arr[2]-0.5*Math.min(arr[1], arr[2])+dp[0]), arr[2]+dp[1]);
		for(int i = 3; i<n; i++) {
			dp[i] = Math.min(Math.min(arr[i]+arr[i-1]+arr[i-2]-Math.min(arr[i], Math.min(arr[i-1], arr[i-2]))+dp[i-3], arr[i]+arr[i-1]-0.5*Math.min(arr[i], arr[i-1])+dp[i-2]), arr[i]+dp[i-1]);
		}
		System.out.println(Math.round(10*dp[n-1])/10+"."+Math.round(10*dp[n-1])%10);
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
