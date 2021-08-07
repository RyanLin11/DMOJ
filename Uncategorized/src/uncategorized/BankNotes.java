package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BankNotes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]d = new int[n];
		int[]cnt = new int[n];
		for(int i = 0; i<n; i++) {
			d[i] = readInt();
		}
		for(int i = 0; i<n; i++) {
			cnt[i] = readInt();
		}
		int k = readInt();
		int[]arr = new int[k+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		for(int i = 0; i<n; i++) {
			for(int j = k; j>=0; j--) {
				if(arr[j]!=Integer.MAX_VALUE) {
					for(int l= 1; l<=cnt[i] && j+d[i]*l<=k; l++) {
						arr[j+d[i]*l] = Math.min(arr[j+d[i]*l], arr[j]+l);
					} 
				}
			}
		}
		System.out.println(arr[k]);
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
