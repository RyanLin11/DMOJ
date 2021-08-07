package dmopc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VictorsMoralDilemma {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), D = readInt();
		int[]psa = new int[N+1];
		for(int i = 1; i<=N; i++) {
			psa[i] = psa[i-1] + readInt();
		}
		int l = 0, r = N;
		for(int i = 0; i<D; i++) {
			int n = readInt();
			if(psa[n+l] - psa[l] >= psa[r] - psa[n+l]) {
				System.out.println(psa[n+l] - psa[l]);
				l = n+l;
			} else {
				System.out.println(psa[r] - psa[n+l]);
				r = n+l;
			}
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
