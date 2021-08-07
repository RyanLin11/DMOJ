package cco05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Segments {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]l, r;
	static int[][]memo;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		l = new int[n];
		r = new int[n];
		memo = new int[n][2];
		for(int i = 0; i<n; i++) {
			l[i] = readInt();
			r[i] = readInt();
		}
		System.out.println(r[0]-1+f(1,1));
	}
	//c==0 prev choice is left, c==1 prev choice is right
	public static int f(int lvl, int c) {
		if(lvl==n) {
			if(c==0) return n-l[n-1];
			else return n-r[n-1];
		}
		if(memo[lvl][c]!=0) return memo[lvl][c];
		int dist = 0;
		//int l1 = l[lvl-1], r1 = r[lvl-1], l2 = l[lvl], r2 = r[lvl];
		if(c==0) { //we are departing from the left side of the prev section
			if(l[lvl-1]>=r[lvl]) dist= l[lvl-1]-l[lvl]+1+f(lvl+1,0); // l1 is right of r2 (l1 r1 is completely right of l2 r2)
			else if(l[lvl-1]<=l[lvl]) dist= r[lvl]-l[lvl-1]+1+f(lvl+1,1); //l1 is left of l2
			else dist= Math.min(2*(r[lvl]-l[lvl-1])+l[lvl-1]-l[lvl]+1+f(lvl+1,0), 2*(l[lvl-1]-l[lvl])+r[lvl]-l[lvl-1]+1+f(lvl+1,1)); //l1 is between l2 r2 interval
		} else { //we are departing from the right side of the prev section
			if(r[lvl-1]<=l[lvl]) dist= r[lvl]-r[lvl-1]+1+f(lvl+1,1); //r1 is left of l2 (l1 r1 is completely left of l2 r2)
			else if(r[lvl-1]>=r[lvl]) dist= r[lvl-1]-l[lvl]+1+f(lvl+1,0);
			else dist= Math.min(2*(r[lvl]-r[lvl-1])+r[lvl-1]-l[lvl]+1+f(lvl+1,0), 2*(r[lvl-1]-l[lvl])+r[lvl]-r[lvl-1]+1+f(lvl+1,1));
		}
		return memo[lvl][c] = dist;
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
