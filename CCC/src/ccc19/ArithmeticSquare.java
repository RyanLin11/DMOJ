package ccc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArithmeticSquare {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M = Integer.MIN_VALUE;
	static int[]row, col;
	public static void main(String[] args) throws IOException {
		int[][]arr = new int[3][3];
		row = new int[3];
		col = new int[3];
		Arrays.fill(row, M);
		Arrays.fill(col, M);
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				String s = next();
				if(s.equals("X")) {
					arr[i][j] = M;
				} else {
					arr[i][j] = Integer.parseInt(s);
				}
			}
		}
		check(arr);
		update(arr);
		print(arr);
		System.out.println(Arrays.toString(row));
		System.out.println(Arrays.toString(col));
	}
	//updates row and column with new values
	public static void check(int[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			int cnt = 0;
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j]!=M) cnt++;
			}
			if(cnt==2) {
				if(arr[i][0]==M) {
					row[i] = arr[i][2] - arr[i][1];
				} else if(arr[i][1]==M) {
					row[i] = (arr[i][2] - arr[i][0])/2;
				} else {
					row[i] = arr[i][1] - arr[i][0];
				}
			}
		}
		for(int j = 0; j<arr[0].length; j++) {
			int cnt = 0;
			for(int i = 0; i<arr.length; i++) {
				if(arr[i][j]!=M) cnt++;
			}
			if(cnt==2) {
				if(arr[0][j]==M) {
					col[j] = arr[2][j] - arr[1][j];
				} else if(arr[1][j]==M) {
					col[j] = (arr[2][j] - arr[0][j])/2;
				} else {
					col[j] = arr[1][j] - arr[0][j];
				}
			}
		}
	}
	//updates the array 
	public static void update(int[][]arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j] == M) {
					if(row[i]!=M) {
						if(i-1>=0 && arr[i-1][j]!=M) arr[i][j] = arr[i-1][j] + row[i];
						else if(i+1<arr.length && arr[i+1][j]!=M) arr[i][j] = arr[i+1][j] - row[i];
					} else if(col[i]!=M) {
						if(j-1>=0 && arr[i][j-1]!=M) arr[i][j] = arr[i][j-1] + col[i];
						else if(j+1<arr[i].length && arr[i][j+1]!=M) arr[i][j] = arr[i][j+1] - col[i];
					}
				}
			}
		}
	}
	public static void print(int[][]arr) {
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
