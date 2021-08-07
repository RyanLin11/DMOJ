package ccc99;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class AKnightlyPursuit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashSet<Integer>[][]set;
	static int[][]dir = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
	static int limit;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for(int i = 0; i<n; i++) {
			int r = readInt(), c = readInt(), pr = readInt(), pc = readInt(), kr = readInt(), kc = readInt();
			set = new HashSet[r+1][c+1];
			for(int j = 0; j<=r; j++) {
				for(int k = 0; k<=c; k++) {
					set[j][k] = new HashSet<>();
				}
			}
			limit = r - pr;
			set[kr][kc].add(0);
			dfs(1, kr, kc);
			boolean win = false;
			boolean stalemate = false;
			int stalematemoves = 0;
			for(int j = pr; j<r; j++) {
				if(set[j][pc].contains(j-pr)) {
					System.out.println("Win in "+(j-pr)+" knight move(s).");
					win = true;
					break;
				} else if(set[j+1][pc].contains(j-pr) && !stalemate) {
					stalemate = true;
					stalematemoves = j-pr;
				}
			}
			if(!win) {
				if(stalemate) System.out.println("Stalemate in "+stalematemoves+" knight move(s).");
				else System.out.println("Loss in "+(limit-1)+" knight move(s).");
			}
		}
	}
	public static void dfs(int step, int r, int c) {
		if(step>limit) return;
		for(int i = 0; i<dir.length; i++) {
			int dr = r+dir[i][0], dc = c+dir[i][1];
			if(dr>=1 && dr<set.length && dc>=1 && dc<set[0].length && !set[dr][dc].contains(step)) {
				set[dr][dc].add(step);
				dfs(step+1, dr, dc);
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
