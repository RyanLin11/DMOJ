package ccc06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Othello {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int[][]arr = new int[8][8]; //0 unoccupied, 1 white, 2 black
		char ch = readCharacter();
		if(ch=='a') {
			arr[3][3] = 1;
			arr[3][4] = 2;
			arr[4][3] = 2;
			arr[4][4] = 1;
		} else if(ch=='b') {
			for(int i = 0; i<8; i++) {
				arr[i][i] = 2;
				arr[i][7-i] = 1;
			}
		} else {
			for(int i = 0; i<8; i++) {
				arr[i][2] = 2;
				arr[i][3] = 2;
				arr[i][4] = 1;
				arr[i][5] = 1;
			}
		}
		int N = readInt();
		for(int i = 0; i<N; i++) {
			int r = readInt()-1, c = readInt()-1;
			int color = i%2==0? 2: 1;
			int op = i%2==0? 1: 2;
			arr[r][c] = color;
			//up
			boolean valid = false;
			for(int j = r-1; j>=0; j--) {
				if(arr[j][c]==color) valid = true;
				if(arr[j][c]!=op) break;
				arr[j][c] = 3;
			}
			check(arr, valid, color, op);
			//down
			valid = false;
			for(int j = r+1; j<8; j++) {
				if(arr[j][c]==color) valid = true;
				if(arr[j][c]!=op) break;
				arr[j][c] = 3;
			}
			check(arr, valid, color, op);
			//left
			valid = false;
			for(int j = c-1; j>=0; j--) {
				if(arr[r][j]==color) valid = true;
				if(arr[r][j]!=op) break;				
				arr[r][j] = 3;
			}
			check(arr, valid, color, op);
			//right
			valid = false;
			for(int j = c+1; j<8; j++) {
				if(arr[r][j]==color) valid = true;
				if(arr[r][j]!=op) break;
				arr[r][j] = 3;
			}
			check(arr, valid, color, op);
			//left diagonal up \
			valid = false;
			for(int j = 1; r-j>=0 && c-j>=0; j++) {
				if(arr[r-j][c-j]==color) valid = true;
				if(arr[r-j][c-j]!=op) break;
				arr[r-j][c-j] = 3;
			}
			check(arr, valid, color, op);
			//left diagonal down \
			valid = false;
			for(int j = 1; r+j<8 && c+j<8; j++) {
				if(arr[r+j][c+j]==color) valid = true;
				if(arr[r+j][c+j]!=op) break;
				arr[r+j][c+j] = 3;
			}
			check(arr, valid, color, op);
			//right diagonal up /
			valid = false;
			for(int j = 1; r-j>=0 && c+j<8; j++) {
				if(arr[r-j][c+j]==color) valid = true;
				if(arr[r-j][c+j]!=op) break;
				arr[r-j][c+j] = 3;
			}
			check(arr, valid, color, op);
			//right diagonal down /
			valid = false;
			for(int j = 1; r+j<8 && c-j>=0; j++) {
				if(arr[r+j][c-j]==color) valid = true;
				if(arr[r+j][c-j]!=op) break;
				arr[r+j][c-j] = 3;
			}
			check(arr, valid, color, op);
		}
		int white = 0, black = 0;
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(arr[i][j]==1) white++;
				else if(arr[i][j]==2) black++;
			}
		}
		System.out.println(black+" "+white);
	}
	public static void check(int[][]arr, boolean valid, int color, int op) {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(arr[i][j]==3) arr[i][j] = valid?color:op;
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
