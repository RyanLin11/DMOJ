package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Candies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		long[][]arr = new long[n][k+1];
		int x = readInt();
		for(int i = 0; i<=x; i++) arr[0][i] = 1;
		for(int i = 1; i<n; i++) {
			x = readInt();
			arr[i][0] = arr[i-1][0];
			for(int j = 1; j<arr[i].length; j++) {
				arr[i][j]=arr[i-1][j]+arr[i][j-1];
				if(j-x-1>=0)arr[i][j]-=arr[i-1][j-x-1];
				arr[i][j]%=mod;
				if(arr[i][j]<0) arr[i][j]+=mod;
			}
			
		}
		System.out.println(arr[n-1][k]%mod);
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
