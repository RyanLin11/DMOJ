package tss17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemB {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		long r; int in;
		public Pair(int in, long r) {
			this.in = in;
			this.r = r;
		}
		public int compareTo(Pair other) {
			if(this.r<other.r) {
				return -1;
			} else if(this.r>other.r) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		long[]dis = new long[n];
		for(int i = 0; i<dis.length; i++) {
			long x = readLong(), y = readLong();
			dis[i] = x*x+y*y;
		}
		Arrays.sort(dis);
		Pair[]query = new Pair[q];
		for(int i = 0; i<q; i++) {
			long r = readLong();
			query[i] = new Pair(i,r*r);
		}
		Arrays.sort(query);
		int[]ans = new int[q];
		for(int i = 0, in = -1; i<q; i++) {
			while(in+1<n && dis[in+1]<=query[i].r) in++;
			ans[query[i].in]=in+1;
		}
		for(int i = 0; i<q; i++) {
			System.out.println(ans[i]);
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
