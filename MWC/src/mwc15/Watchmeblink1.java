package mwc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Watchmeblink1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		int j = readInt();
		long[][]s = new long[3][n+1];
		for(int i = 0; i<j; i++) {
			int l = readInt()-1;
			int r = readInt()-1;
			int f = readInt();
			int t = readInt()-1;
			s[t][l]+=f;
			s[t][r+1]-=f;
		}
		long[]cnt = new long[3];
		for(int a = 0; a<s.length; a++) {
			if(s[a][0]<k)cnt[a]++;
			for(int b = 1; b<s[a].length-1; b++) {
				s[a][b]+=s[a][b-1];
				if(s[a][b]<k)cnt[a]++;
			}
		}
		for(int i = 0; i<cnt.length; i++) {
			System.out.println(cnt[i]);
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
