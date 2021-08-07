package ccc04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuperPlumber {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		while(n!=0 && m!=0) {
			int[][]arr = new int[n][m];
			for(int i = 0; i<n; i++) {
				char[]c = next().toCharArray();
				for(int j = 0; j<m; j++) {
					if(c[j]=='*') {
						arr[i][j]=-1;
					} else if(Character.isDigit(c[j])){
						arr[i][j]=Integer.parseInt(c[j]+"");
					}
				}
			}
			int[][]dp = new int[n][m]; dp[n-1][0] = arr[n-1][0];
			for(int i = n-2; i>=0; i--) {
				if(dp[i+1][0]!=-1 && arr[i+1][0]!=-1)dp[i][0] = dp[i+1][0]+arr[i][0];
				else dp[i][0] = -1;
			}
			for(int j = 1; j<m; j++) {
				if(dp[0][j-1]!=-1 && arr[0][j]!=-1) dp[0][j] = dp[0][j-1]+arr[0][j];
				else dp[0][j] = -1;
				for(int i = 1; i<n; i++) {
					if(arr[i][j]!=-1 && (dp[i][j-1]!=-1||dp[i-1][j]!=-1)) {
						if(dp[i][j-1]!=-1)dp[i][j] = dp[i][j-1]+arr[i][j];
						if(dp[i-1][j]!=-1)dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+arr[i][j]);
					} else {
						dp[i][j] = -1;
					}
				}
				int[]temp = new int[n];
				if(dp[n-1][j-1]!=-1 && arr[n-1][j]!=-1) temp[n-1]=dp[n-1][j-1]+arr[n-1][j];
				else temp[n-1] = -1;
				for(int i = n-2; i>=0; i--) {
					if(arr[i][j]!=-1 && (dp[i][j-1]!=-1||temp[i+1]!=-1)){
						if(temp[i+1]!=-1) temp[i] = temp[i+1]+arr[i][j];
						if(dp[i][j-1]!=-1) temp[i] = Math.max(temp[i],dp[i][j-1]+arr[i][j]);
					} else {
						temp[i] = -1;
					}
				}
				for(int i = 0; i<n; i++) {
					dp[i][j] = Math.max(dp[i][j], temp[i]);
				}
			}
			System.out.println(dp[n-1][m-1]);
			n = readInt(); m = readInt();
		}
	}
	public static void print(int[][]dp) {
		for(int i = 0; i<dp.length; i++) {
			for(int j = 0; j<dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
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
