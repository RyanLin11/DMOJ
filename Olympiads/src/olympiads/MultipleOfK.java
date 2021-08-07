package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultipleOfK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[]arr = new int[n+1];
		int[]dp = new int[k];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		int maxLength = -1;
		for(int i = 1; i<=n; i++) {
			arr[i] = (arr[i-1]+readInt())%k;
			if(dp[arr[i]]>=0) {
				maxLength = Math.max(maxLength, i-dp[arr[i]]);
			} else {
				dp[arr[i]] = i;
			}
		}
		System.out.println(maxLength);
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
