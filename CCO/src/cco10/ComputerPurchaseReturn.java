package cco10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ComputerPurchaseReturn {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[] wt;
	static ArrayList<Integer>[]val;
	static int memo[][];
	public static void main(String[] args) throws IOException {
		int T = readInt();
		int N = readInt();
		wt = new ArrayList[T];
		val = new ArrayList[T];
		for(int i = 0; i<T; i++) {
			wt[i] = new ArrayList<>();
			val[i] = new ArrayList<>();
		}
		for(int i = 0; i<N; i++) {
			int c = readInt();
			int v = readInt();
			int t = readInt()-1;
			wt[t].add(c);
			val[t].add(v);
		}
		int b = readInt();
		memo = new int[T][b+1];
		int ans = f(0,b);
		if(ans<0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	public static int f(int d, int w) {
		if(w<0) return Integer.MIN_VALUE;
		if(d==wt.length) return 0;
		if(wt[d].size()==0) return Integer.MIN_VALUE;
		if(memo[d][w]!=0) return memo[d][w];
		int max = 0;
		for(int i = 0; i<wt[d].size(); i++) {
			max = Math.max(max, val[d].get(i)+f(d+1, w-wt[d].get(i)));
		}
		return memo[d][w] = max;
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
