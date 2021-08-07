package coci09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Rimski {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		char[]s = next().toCharArray();
		char[]c = {'C','L','X','V','I'};
		int[]f = new int[5];
		for(int i = 0; i<s.length; i++) {
			for(int j = 0; j<c.length; j++) {
				if(s[i]==c[j]) {
					f[j]++;
					break;
				}
			}
		}
		int[]key = {0,1,2,3};
		int[]val = {2,2,4,4};
		String out = "";
		for(int i = 0; i<key.length; i++) {
			while(f[key[i]]>0) {
				if(f[key[i]]==1 && f[val[i]]==1) {
					if(i==2) {
						if(f[3]>0 && f[4]==1) {
							out+=c[key[i]];
							f[key[i]]--;
							continue;
						}
					}
					out+=c[val[i]]+""+c[key[i]];
					f[val[i]]--;
				} else if(i==1 && f[key[i]]==1 && f[2]==2 && f[3]==0 && f[4]==1) {
					out+=c[val[i]]+""+c[key[i]];
					f[val[i]]--;
				}
				else {
					out+=c[key[i]];
				}
				f[key[i]]--;
			}
		}
		for(int i = 0; i<f[4]; i++) {
			out+=c[4];
		}
		System.out.println(out);
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
