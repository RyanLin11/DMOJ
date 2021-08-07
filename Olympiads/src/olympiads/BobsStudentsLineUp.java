package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BobsStudentsLineUp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		String s = next();
		int[]pre = new int[n];
		int[]suf = new int[n];
		pre[0] = s.charAt(0)=='L'?1:0;
		for(int i = 1; i<pre.length; i++) {
			if(s.charAt(i)=='L') {
				pre[i] = pre[i-1]+1;
			} else {
				pre[i] = pre[i-1];
			}
		}
		suf[n-1] = s.charAt(n-1)=='R'?1:0;
		for(int i = n-2; i>=0; i--) {
			if(s.charAt(i)=='R') {
				suf[i] = suf[i+1]+1;
			} else {
				suf[i] = suf[i+1];
			}
		}
		int min = Math.min(pre[n-2], suf[1]);
		for(int i = 1; i<n-1; i++) {
			min = Math.min(min, pre[i-1]+suf[i+1]);
		}
		System.out.println(min);
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
