package dmopc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Harvest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		long k = readLong();
		int[]row = new int[n];
		int[]dif = new int[n+1];
		Arrays.fill(row, m);
		for(int i = 0; i<m; i++) {
			int l = readInt()-1;
			int r = readInt()-1;
			dif[l]--;
			dif[r+1]++;
		}
		if(k==0) {
			System.out.println(0);
			return;
		}
		row[0] = row[0]+dif[0];
		for(int i = 1; i<row.length; i++) {
			dif[i]+=dif[i-1];
			row[i]+=dif[i];
		}
		int min = Integer.MAX_VALUE;
		long sum = 0;
		for(int l = 0, r=0; r<row.length; r++) {
			sum+=row[r];
			if(sum>=k) {
				while(l<=r && sum-row[l]>=k) {
					sum-=row[l];
					l++;
				}
				min = Math.min(min, r-l+1);
			}
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
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
