package coci14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coci {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]x, y;
	static int[][]psa, arr;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		x = new int[N];
		y = new int[N];
		psa = new int[651][651];
		arr = new int[651][651];
		int a = 0, b = 0;
		for(int i = 0; i<N; i++) {
			x[i] = readInt();
			y[i] = readInt();
			psa[x[i]][y[i]]++;
			arr[x[i]][y[i]]++;
		}
		for(int i = 1; i<psa.length; i++) {
			for(int j = 0; j<psa[i].length; j++) {
				psa[i][j] += psa[i-1][j];
			}
		}
		for(int j = 1; j<psa[0].length; j++) {
			for(int i = 0; i<psa.length; i++) {
				psa[i][j] += psa[i][j-1];
			}
		}
		for(int i = 0; i<N; i++) {
			int hi = psa[650][650] - psa[x[i]][650] - psa[650][y[i]] + psa[x[i]][y[i]] + 1;
			int lo = N;
			if(x[i]==650) {
				lo -= arr[0][y[i]];
			} 
			if(y[i]==650) {
				lo -= arr[x[i]][0];
			}
			if(x[i]>0 && y[i]>0) lo -= psa[x[i]-1][y[i]-1];
			System.out.println(hi+" "+lo);
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
