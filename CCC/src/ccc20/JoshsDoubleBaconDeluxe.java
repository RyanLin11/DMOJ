package ccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JoshsDoubleBaconDeluxe {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		//last[i] = index of the last i in the array
		int[]last = new int[500001];
		Arrays.fill(last, -1);
		for(int i = N-1; i>=0; i--) {
			if(last[arr[i]] < 0) {
				last[arr[i]] = i;
			}
		}
		//dp[i] = probability if burger of person i is chosen randomly
		double[]dp = new double[N];
		for(int i = N-1; i>=0; i--) {
			if(arr[i] == arr[0]) {
				dp[i] = 1;
			} else if(last[arr[i]] == N-1) {
				dp[i] = 0;
			} else {
				dp[i] = (1.0/(arr.length-last[arr[i]])) * (1 + dp[last[arr[i]]+1]);
			}
			if(i+1<N) dp[i] += dp[i+1];
		}
		//calculate answer
		System.out.println((1.0/arr.length)*dp[0]);
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
