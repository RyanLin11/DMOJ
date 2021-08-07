package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class LCS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]s = next().toCharArray();
		char[]t = next().toCharArray();
		int[][]arr = new int[s.length+1][t.length+1];
		for(int i = 1; i<arr.length; i++) {//increment s string
			for(int j = 1; j<arr[i].length; j++) { //increment t string
				if(s[i-1]==t[j-1]) arr[i][j] = 1+arr[i-1][j-1];
				else arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = s.length, j = t.length;arr[i][j]!=0;) {
			if(arr[i][j]==arr[i-1][j]) {
				i--;
			} else if(arr[i][j]==arr[i][j-1]) {
				j--;
			} else {
				sb.append(s[i-1]);
				i--; j--;
			}
		}
		System.out.println(sb.reverse());
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
