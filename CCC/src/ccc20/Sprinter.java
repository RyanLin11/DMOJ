package ccc20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Sprinter {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int t, d;
		public Pair(int t, int d) {
			this.t = t ;
			this.d = d;
		}
		public int compareTo(Pair other) {
			if(this.t<other.t) {
				return -1;
			} else if(this.t>other.t) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair[]p = new Pair[n];
		for(int i = 0; i<n; i++) {
			p[i] = new Pair(readInt(),readInt());
		}
		Arrays.sort(p);
		double max = 0;
		for(int i = 1; i<p.length; i++) {
			max = Math.max(max,Math.abs(p[i].d-p[i-1].d)/(double)(p[i].t-p[i-1].t));
		}
		System.out.println(max);
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
