package ecoo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class MutantChildren {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i = 0; i<10; i++) {
			String a = next(), b = next(), c = next();
			int[]dp1 = new int[a.length()]; //switch part of b into a
			int[]dp2 = new int[b.length()]; //switch part of a into b
			int awc = 0, bwc = 0;
			for(int j = 0; j<a.length(); j++) {
				if(a.charAt(j)!=c.charAt(j)) awc++;
				if(b.charAt(j)!=c.charAt(j)) bwc++;
				if(a.charAt(j)==c.charAt(j) && a.charAt(j)!=b.charAt(j)) {
					dp1[j] = -1; dp2[j] = 1;
				} else if(b.charAt(j)==c.charAt(j) && a.charAt(j)!=b.charAt(j)) {
					dp1[j] = 1; dp2[j] = -1;
				}
			}
			int cur1 = 0, best1 = Integer.MIN_VALUE;
			int cur2 = 0, best2 = Integer.MIN_VALUE;
			for(int j = 0; j<dp1.length; j++) {
				if(cur1<dp1[j]) {
					cur1 = 0;
				}
				if(cur2<dp2[j]) {
					cur2 = 0;
				}
				cur1+=dp1[j];
				cur2+=dp2[j];
				if(cur1>best1) {
					best1 = cur1;
				}
				if(cur2>best2) {
					cur2 = best2;
				}
			}
			double ans = Math.max(awc-best1, bwc-best2)/(double)a.length();
			ans = Math.round(ans*100)/100.0;
			System.out.println(df.format(ans));
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
