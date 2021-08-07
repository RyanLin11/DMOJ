package ccc09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wireless {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int[][]arr = new int[n+1][m];
		for(int i = 0; i<k; i++) {
			int col = readInt()-1, row = readInt()-1, r = readInt(), b = readInt();
			for(int j = Math.max(0, col-r); j<=Math.min(m-1, col+r); j++) {//vertical
				int s = (int)Math.sqrt(Math.pow(r, 2)-Math.pow(col-j, 2));
				arr[Math.max(0, row-s)][j]+=b;
				arr[Math.min(n-1, row+s)+1][j]-=b;
			}
		}
		int max = 0, freq = 0;
		for(int j = 0; j<m; j++) {
			if(arr[0][j]>max) {
				max = arr[0][j];
				freq = 1;
			} else if(arr[0][j]==max){
				freq++;
			}
			for(int i = 1; i<=n; i++) {
				arr[i][j]+=arr[i-1][j];
				if(arr[i][j]>max) {
					max = arr[i][j];
					freq = 1;
				} else if(arr[i][j]==max){
					freq++;
				}
			}
		}
		System.out.println(max+"\n"+freq);
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
