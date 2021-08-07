package ccc10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Firehose {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]h;
	static int H, k;
	public static void main(String[] args) throws IOException {
		H = readInt();
		h = new int[H];
		for(int i = 0; i<H; i++) {
			h[i] = readInt();
		}
		Arrays.sort(h);
		int l = 0, r = H-1;
		int max = 1000000 - h[H-1] + h[0];
		for(int i = 1; i<H; i++) {
			if(h[i] - h[i-1] > max) {
				l = i;
				r = i-1;
				max = h[i] - h[i-1];
			}
		}
		k = readInt();
		System.out.println(g(l, r, k));
	}
	public static double g(int l, int r, int d) {
		double min = Double.MAX_VALUE;
		for(int i = l; i!=r; i=(i+1)%H) {
			for(int j = 1; j<d; j++) {
				min = Math.min(min, Math.max(g(l, i, j) , g((i+1)%H, r, d-j)));
			}
		}
		min = l<=r? Math.min(min, (h[r] - h[l]) / (double)(d*2)) : Math.min(min, (1000000 - h[l] + h[r])/(double)(d*2));
		return min;
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
