package ioi00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palindrome {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		char[]c = next().toCharArray();
		int[]dp1 = new int[n+1];
		int[]dp2 = new int[n+1];
		int max = 1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<c.length-i-1; j++) {
				dp2[j+1] = Math.max(dp2[j], dp1[j+1]);
				if(c[i]==c[c.length-j-1]) {
					dp2[j+1] = Math.max(dp2[j+1], dp1[j]+2);
					if(dp2[j+1]>=max) {
						max = dp2[j+1];
						if(c.length-i-j-1>1) max++;
					}
				}
			}
			dp1 = dp2;
			dp2 = new int[n+1];
		}
		System.out.println(n-max);
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
