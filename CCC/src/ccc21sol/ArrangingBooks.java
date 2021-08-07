package ccc21sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrangingBooks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int ml = 0, sl = 0, lm = 0, sm = 0, ls = 0, ms = 0;
		int s = 0, m = 0, l = 0;
		char[]c = next().toCharArray();
		//count number of s, m, and l's
		for(int i = 0; i<c.length; i++) {
			if(c[i] == 'S') {
				s++;
			} else if(c[i] == 'M') {
				m++;
			} else {
				l++;
			}
		}
		//L section
		for(int i = 0; i<l; i++) {
			if(c[i] == 'S') {
				sl++;
			} else if(c[i] == 'M'){
				ml++;
			}
		}
		//M section
		for(int i = l; i<l+m; i++) {
			if(c[i] == 'S') {
				sm++;
			} else if(c[i] == 'L'){
				lm++;
			}
		}
		//S section
		for(int i = l+m; i<l+m+s; i++) {
			if(c[i] == 'M') {
				ms++;
			} else if(c[i] == 'L'){
				ls++;
			}
		}
		//swap ls <> sl, lm <> ml, sm <> ms
		int swaps = 0;
		int x = Math.min(ls, sl);
		ls -= x;
		sl -= x;
		swaps += x;
		int y = Math.min(lm, ml);
		lm -= y;
		ml -= y;
		swaps += y;
		int z = Math.min(sm, ms);
		sm -= z;
		ms -= z;
		swaps += z;
		swaps += (int)((2/3.0) * (ls + sl + lm + ml + sm + ms));
		//print out final answer
		System.out.println(swaps);
		
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
