package ccc08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nukit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][]reaction = {{2,1,0,2},{1,1,1,1},{0,0,2,1},{0,3,0,0},{1,0,0,1}};
	static int[][][][]roland;
	static int[][][][]patrick;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			int d = readInt();
			roland = new int[a+1][b+1][c+1][d+1];
			patrick = new int[a+1][b+1][c+1][d+1];
			System.out.println(Patrick(a,b,c,d)?"Patrick":"Roland");
		}
	}
	public static boolean Roland(int a, int b, int c, int d) {
		if(roland[a][b][c][d]!=0) return roland[a][b][c][d]==1;
		for(int i = 0; i<reaction.length; i++) {
			int a1 = a-reaction[i][0];
			int b1 = b-reaction[i][1];
			int c1 = c-reaction[i][2];
			int d1 = d-reaction[i][3];
			if(a1>=0&&b1>=0&&c1>=0&&d1>=0) {
				if(!Patrick(a1,b1,c1,d1)) {
					roland[a][b][c][d]=2;
					return false;
				}
			}
		}
		roland[a][b][c][d]=1;
		return true;
	}
	public static boolean Patrick(int a, int b, int c, int d) {
		if(patrick[a][b][c][d]!=0) return patrick[a][b][c][d]==1;
		for(int i = 0; i<reaction.length; i++) {
			int a1 = a-reaction[i][0];
			int b1 = b-reaction[i][1];
			int c1 = c-reaction[i][2];
			int d1 = d-reaction[i][3];
			if(a1>=0&&b1>=0&&c1>=0&&d1>=0) {
				if(Roland(a1,b1,c1,d1)==true) {
					patrick[a][b][c][d] = 1;
					return true;
				}
			}
		}
		patrick[a][b][c][d] = 2;
		return false;
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
