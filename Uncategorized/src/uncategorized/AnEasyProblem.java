package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class AnEasyProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]dp = new int[30];
		for(int i = 0; i<n; i++) {
			int x = readInt();
			int max = 0;
			ArrayList<Integer>list = new ArrayList<>();
			for(int j = 0; j<dp.length; j++) {
				int y = x&(1<<j);
				if(y>0) {
					max=Math.max(max,dp[j]);
					list.add(j);
				}
			}
			for(int j: list) {
				dp[j] = Math.max(dp[j], max+1);
			}
		}
		int max = 0;
		for(int i = 0; i<dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
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
