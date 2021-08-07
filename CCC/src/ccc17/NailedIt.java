package ccc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class NailedIt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]fre = new int[2001];
		for(int i = 0; i<n; i++) {
			fre[readInt()]++;
		}
		int[]ans = new int[4001];
		for(int i = 2; i<ans.length; i+=2) {
			for(int j = Math.max(1, i-2000); j<=i/2-1; j++) {
				ans[i]+=Math.min(fre[j],fre[i-j]);
			}
			ans[i]+=fre[i/2]/2;
		}
		for(int i = 1; i<ans.length; i+=2) {
			for(int j = Math.max(1, i-2000); j<=i/2; j++) {
				ans[i]+=Math.min(fre[j], fre[i-j]);
			}
		}
		int max = 0, cnt = 0;
		for(int i = 0; i<ans.length; i++) {
			if(ans[i]>max) {
				max = ans[i];
				cnt = 1;
			} else if(ans[i]==max) {
				cnt++;
			}
		}
		System.out.println(max+" "+cnt);
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
