package ccchk15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindingNumberOfPairs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		long mod = (long)1e9+7;
		int[]arr = new int[n];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		int ceil = n-1; long cnt = 0;
		for(int i = 1; i<arr.length; i++) {
			while(ceil>=0 && arr[ceil]+arr[i]>m)ceil--;
			if(ceil<0) break;
			cnt+=Math.min(ceil+1, i);
		}
		System.out.println(cnt%mod);
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
