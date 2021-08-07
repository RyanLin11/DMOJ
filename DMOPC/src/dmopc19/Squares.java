package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Squares {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	/*public static void main(String[] args) throws IOException {
		int r = readInt();
		int c = readInt();
		int[][]arr = new int[r+1][c+1];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 1; i<=r; i++) {
			for(int j = 1; j<=c; j++) {
				if(i==1 && j==1) arr[i][j] = readInt();
				else arr[i][j] = readInt()+Math.min(arr[i-1][j], arr[i][j-1]);
			}
		}
		System.out.println(arr[r][c]);
	}*/
	public static String next () throws IOException {
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
