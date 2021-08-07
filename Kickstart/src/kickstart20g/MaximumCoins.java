package kickstart20g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumCoins {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt();
			long[]arr = new long[2*N+2];
			int shift = N+1;
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					arr[k+shift] +=  readLong();
					
				}
				shift--;
			}
			long max = 0;
			for(int j = 0; j<arr.length; j++) {
				max = Math.max(max, arr[j]);
			}
			System.out.println("Case #"+(i+1)+": "+max);
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
