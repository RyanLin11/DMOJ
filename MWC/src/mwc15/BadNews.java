package mwc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BadNews {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][]arr;
	static char[]word;
	static boolean[][]vis;
	static int[][]dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		arr = new char[N][N];
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j] = Character.toLowerCase(readCharacter());
			}
		}
		for(int i = 0; i<Q; i++) {
			word = next().toLowerCase().toCharArray();
			boolean flag = false;
			for(int j = 0; j<arr.length && !flag; j++) {
				for(int k = 0; k<arr[j].length && !flag; k++) {
					vis = new boolean[N][N];
					vis[j][k] = true;
					flag = verify(0, j, k, dir);
				}
			}
			System.out.println(flag?"good puzzle!":"bad puzzle!");
		}
	}
	public static boolean verify(int idx, int r, int c, int[][]dir) {
		if(arr[r][c]!=word[idx]) return false;
		if(idx==word.length-1) return true;
		for(int i = 0; i<dir.length; i++) {
			int dr = r+dir[i][0], dc = c+dir[i][1];
			if(dr>=0 && dr<arr.length && dc>=0 && dc<arr.length && !vis[dr][dc]) {
				vis[dr][dc] = true;
				if(verify(idx+1, dr, dc, dir)) return true;
				vis[dr][dc] = false;
			}
		}
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
