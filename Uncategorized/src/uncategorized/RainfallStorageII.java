package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RainfallStorageII {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException  {
		int n = readInt();
		int[]arr = new int[n];
		int[]pre = new int[n];
		int[]suf = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = readInt();
		}
		pre[0] = arr[0];
		for(int i = 1; i<n; i++) {
			pre[i] = Math.max(arr[i], pre[i-1]);
		}
		suf[n-1] = arr[n-1];
		for(int i = n-2; i>=0; i--) {
			suf[i] = Math.max(arr[i], suf[i+1]);
		}
		long r = 0;
		for(int i = 1; i<n-1; i++) {
			int p = Math.min(pre[i-1], suf[i+1])-arr[i];
			if(p>0) {
				r+=p;
			}
		}
		System.out.println(r);
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
