package coci14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teta {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int k = readInt();
		int[]p = new int[k];
		for(int i = 0; i<p.length; i++) {
			p[i] = readInt();
		}
		int x = readInt();
		int[]m = new int[4];
		for(int i = 0; i<m.length; i++) {
			m[i] = readInt()-1;
		}
		int t = readInt();
		int[]f = new int[k];
		for(int i = 0; i<t; i++) {
			f[readInt()-1]++;
		}
		int ans = 0;
		while(true) {
			int price = 0;
			for(int i = 0; i<4; i++) {
				if(f[m[i]]!=0) price+=p[m[i]];
			}
			if(price>=x) {
				ans+=x;
				for(int i = 0; i<4; i++) {
					if(f[m[i]]!=0)f[m[i]]--;
				}
			} else {
				break;
			}
		}
		for(int i = 0; i<f.length; i++) {
			ans+=f[i]*p[i];
		}
		System.out.println(ans);
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
