package coci15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ozljeda {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int K = readInt();
		long[]psa = new long[4*(K+1)+1];
		for(int i = 1; i<=K; i++) {
			psa[i] = readLong()^psa[i-1];
		}
		for(int i = K+1; i<psa.length; i++) {
			psa[i] = psa[i-1]^psa[i-K-1];
			psa[i]^=psa[i-1];
		}
		int mod = 2*K+2;
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int l = (int)((readLong()-1)%mod+1), r = (int)((readLong()-1)%mod+1);
			if(l<=r) System.out.println(psa[r]^psa[l-1]);
			else System.out.println(psa[mod+r]^psa[l-1]);
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
