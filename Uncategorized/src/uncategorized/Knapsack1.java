package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Knapsack1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]wt;
	static int[] val;
	static long[]arr1;
	static long[]arr2;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int w = readInt();
		wt = new int[n];
		val = new int[n];
		for(int i = 0; i<n; i++) {
			wt[i] = readInt();
			val[i] = readInt();
		}
		arr1 = new long[w+1];
		Arrays.fill(arr1, -1);
		if(w-wt[0]>=0) arr1[w-wt[0]] = val[0];
		arr1[w] = 0;
		arr2 = new long[w+1];
		Arrays.fill(arr2, -1);
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<arr1.length; j++) {
				if(arr1[j]!=-1) {
					if(j-wt[i]>=0) arr2[j-wt[i]] = arr1[j]+val[i];
					arr2[j] = arr1[j];
				}
			}
			arr1 = arr2;
			arr2 = new long[w+1];
			Arrays.fill(arr2, -1);
		}
		long max = 0;
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i]>max) {
				max = arr1[i];
			}
		}
		System.out.println(max);
	}
	public static int f(int d, int w) {
		return Math.max(f(d+1,w-wt[d])+val[d], f(d+1,w));
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
