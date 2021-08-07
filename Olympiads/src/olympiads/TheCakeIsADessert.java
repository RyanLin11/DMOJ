package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheCakeIsADessert {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		long[][]arr = new long[n+2][m+2];
		for(int i = 0; i<k; i++) {
			int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
			arr[r1][c1]++;
			arr[r1][c2+1]--;
			arr[r2+1][c1]--;
			arr[r2+1][c2+1]++;
		}
		psa2d(arr);
		psa2d(arr);
		int q = readInt();
		for(int i = 0; i<q; i++) {
			int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
			System.out.println(arr[r2][c2]-arr[r2][c1-1]-arr[r1-1][c2]+arr[r1-1][c1-1]);
		}
	}
	public static void psa2d(long[][]arr) {
		sumrow(arr); sumcol(arr);
	}
	public static void sumrow(long[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 1; j<arr[i].length; j++) {
				arr[i][j]+=arr[i][j-1];
			}
		}
	}
	public static void sumcol(long[][]arr) {
		for(int j = 0; j<arr[0].length; j++) {
			for(int i = 1; i<arr.length; i++) {
				arr[i][j]+=arr[i-1][j];
			}
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
