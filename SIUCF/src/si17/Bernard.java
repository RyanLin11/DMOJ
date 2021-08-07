package si17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bernard {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		long[]arr = new long[n];
		arr[0] = readInt();
		for(int i = 1; i<=Math.min(n-1,k); i++) {
			arr[i] = Math.max(arr[i-1], readInt());
		}
		for(int i = k+1; i<n; i++) {
			arr[i] = Math.max(arr[i-1], arr[i-k-1]+readInt());
		}
		System.out.println(arr[arr.length-1]);
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
