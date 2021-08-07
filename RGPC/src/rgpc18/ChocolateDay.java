package rgpc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChocolateDay {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[]arr = new int[n+2];
		for(int i = 0; i<t; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			arr[a]+=c; arr[b+1]-=c;
		}
		for(int i = 1; i<=n; i++) {
			arr[i]+=arr[i-1];
		}
		for(int i = 1; i<=n; i++) {
			arr[i]+=arr[i-1];
		}
		int lim = readInt();
		int max = 0;
		for(int r = 1, l = 1; r<=n; r++) {
			while(l<=r && arr[r]-arr[l-1]>lim) {
				l++;
			}
			max = Math.max(max, r-l+1);
		}
		System.out.println(max);
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
