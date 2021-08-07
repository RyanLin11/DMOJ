package coci07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Muzicari {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt(), N = readInt();
		int[]t = new int[N+1];
		for(int i = 1; i<=N; i++) {
			t[i] = readInt();
		}
		int[]m = new int[T+1];
		m[0] = -1;
		for(int i = 1; i<=N; i++) {
			for(int j = T; j-t[i]>=0; j--) {
				if(m[j]==0 && m[j-t[i]]!=0) {
					m[j] = i;
				}
			}
		}
		int[]ans = new int[N+1];
		Arrays.fill(ans, -1);
		for(int i = T; i>=0; i--) {
			if(m[i]!=0) {
				while(m[i]!=-1) {
					ans[m[i]] = i-t[m[i]];
					i-=t[m[i]];
				}
				break;
			}
		}
		int time = 0;
		for(int i = 1; i<ans.length; i++) {
			if(ans[i]==-1) {
				ans[i] = time;
				time+=t[i];
			}
		}
		for(int i = 1; i<ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
		System.out.println();
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
