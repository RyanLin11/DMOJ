package dmopc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RibbonColouringFun {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		int[]arr = new int[n+1];
		for(int i = 0; i<q; i++) {
			int l = readInt(), r = readInt();
			arr[l]++; arr[r]--;
		}
		int cnt = arr[0]>0?1:0;
		for(int i = 1; i<n; i++) {
			arr[i]+=arr[i-1];
			if(arr[i]>0) cnt++;
		}
		System.out.println((n-cnt)+" "+cnt);
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
