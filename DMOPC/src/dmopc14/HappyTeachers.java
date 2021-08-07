package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HappyTeachers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]h, e, p;
	static int n, s;
	public static void main(String[] args) throws IOException {
		n = readInt();
		h = new int[n];
		e = new int[n];
		p = new int[n];
		for(int i = 0; i<n; i++) {
			h[i] = readInt();
			e[i] = readInt();
			p[i] = readInt();
		}
		s = readInt();
		int[][]val = new int[n][102];
		//make a table of possible happiness values
		for(int i = 0; i<n; i++) {
			int nxt = h[i];
			for(int j = 1; j<102; j++) {
				if(nxt<=0) {
					nxt = 0;
				}
				val[i][j]=nxt+val[i][j-1];
				nxt-=e[i];
			}
		}
		int totmax = 0;
		int mindur = Integer.MAX_VALUE;
		//run dp
		int[][]dp = new int[n][s+1];
		int[][]time = new int[n][s+1];
		for(int j = 0; j<s+1; j++) {
			int max = 0;
			for(int k = 0; j-k*p[0]>=0&&k<102/* && val[0][k]!=0*/; k++) {
				int temp = val[0][k];
				if(temp>max) {
					max = temp;
					time[0][j] = k;
				}
				if(temp>totmax) {
					totmax = temp;
					mindur = time[0][j];
				} else if(temp==totmax) {
					mindur = Math.min(mindur, time[0][j]);
				}
			}
			dp[0][j] = max;
		}
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<s+1; j++) {
				//int max = dp[i-1][j];
				//time[i][j] = time[i-1][j];
				int max = 0;
				for(int k = 0; j-k*p[i]>=0&&k<102/* &&val[i][k]!=0*/ ; k++) {
					int temp = val[i][k]+dp[i-1][j-k*p[i]];
					if(temp>max) {
						max = temp;
						time[i][j] = k+time[i-1][j-k*p[i]];
					} else if(temp==max) {
						time[i][j] = Math.min(time[i][j], k+time[i-1][j-k*p[i]]);
					}
					if(temp>totmax) {
						totmax = temp;
						mindur = time[i][j];
					} else if(temp==totmax) {
						mindur = Math.min(mindur, time[i][j]);
					}
				}
				dp[i][j] = max;
			}
		}
		//print2d(dp);
		System.out.println(dp[n-1][s]);
		System.out.println(mindur);
	}
	public static void print2d(int[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
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
