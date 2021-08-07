package ccc09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LightsGoingOnAndOff {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]arr;
	public static void main(String[] args) throws IOException {
		int r = readInt();
		int c = readInt();
		arr = new int[r][c];
		int[][]memo = new int[r][c];
		for(int i = 0; i<c; i++) {
			memo[0][i] = arr[r-1][i];
		}
		int index = 1;
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				arr[i][j] = readInt();
			}
		}
		for(int i = 1; i<r; i++) {
			int[][]sol = deepcopy();
			for(int j = i; j<r; j++) {
				for(int k = 0; k<c; k++) {
					sol[j][k] = sol[j-1][k]==sol[j][k]?0:1;
				}
			}
			boolean unique = true;
			for(int j = 0; j<index; j++) {
				if(equals(memo[j],sol[r-1])) {
					unique = false;
					break;
				}
			}
			if(unique) {
				for(int j = 0; j<c; j++) {
					memo[index][j] = sol[r-1][j];
				}
				index++;
			}
		}
		System.out.println(index);
	}
	public static int[][]deepcopy(){
		int[][]sol = new int[arr.length][arr[0].length];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				sol[i][j] = arr[i][j];
			}
		}
		return sol;
	}
	public static int[] copy(int r) {
		int[]temp = new int[arr[0].length];
		for(int i = 0; i<arr[0].length; i++) {
			temp[i] = arr[r][i];
		}
		return temp;
	}
	public static boolean equals(int[]arr1, int[]arr2) {
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
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
