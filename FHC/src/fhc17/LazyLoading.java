package fhc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class LazyLoading {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			int[]arr = new int[n];
			for(int j = 0; j<arr.length; j++) {
				arr[j] = readInt();
			}
			Arrays.sort(arr);
			int cnt = 0;
			for(int j = 0,k=arr.length-1; j<=k;) {
				int x = (int)Math.ceil(50.0/arr[k]);
				if(j+x-1<=k) {
					j+=x-1;
					k--;
					cnt++;
				} else {
					break;
				}
			}
			System.out.println("Case #"+(i+1)+": "+cnt);
		}

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
