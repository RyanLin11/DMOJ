package coci15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Perica {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		long[]arr = new long[k];
		long[]num = new long[n];
		for(int i = 0; i<n; i++) {
			num[i] = readInt();
		}
		Arrays.sort(num);
		long sum = 0;
		arr[0] = 1;
		if(k==0) sum = arr[0];
		for(int i = 1; i<num.length; i++) {
			for(int j = Math.min(i, k-1); j>0; j--) {
				arr[j]+=arr[j-1];
				arr[j]%=mod;
			}
			sum+=num[i]*arr[k-1];
			sum%=mod;
		}
		System.out.println(sum);
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
