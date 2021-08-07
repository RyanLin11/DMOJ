package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MagicalBribery {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr, memo;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		arr = new int[n+1];
		memo = new int[n+1];
		for(int i = 1; i<arr.length; i++) {
			arr[i] = readInt();
		}
		System.out.println(f(n));
	}
	public static int f(int x) {
		if(x==0) return 0;
		if(memo[x]!=0) return memo[x];
		int max = 0;
		for(int i = 1; i<=x; i++) {
			max = Math.max(max, arr[i]+f(x-i));
		}
		return memo[x] = max;
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
