package dmopc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class CafeteriaConfrontationConundrum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int m, in;
		public Pair(int m, int in) {
			this.m = m;
			this.in = in;
		}
		public int compareTo(Pair other) {
			if(this.m>other.m) return 1;
			else return -1;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int[]dp = new int[n+1];
		for(int i = 1; i<=n; i++) {
			int m = readInt();
			dp[i] = m;
		}
		for(int i = 1; i<=n; i++) {
			int v = readInt();
			if(v>0) dp[i]+=dp[v];
		}
		Deque<Pair>dq = new LinkedList<>();
		for(int i = n; i>0; i--) {
			while(!dq.isEmpty() && dq.peekLast().m<dp[i]) dq.pollLast();
			dq.offerLast(new Pair(dp[i],i));
		}
		Pair[]pairs = new Pair[q];
		for(int i = 0; i<q; i++) {
			int p = readInt(), c = readInt();
			pairs[i] = new Pair(c-p,i);
		}
		Arrays.sort(pairs);
		int[]ans = new int[q];
		for(Pair p: pairs) {
			if(p.m<=0) {
				ans[p.in]= -1;
				continue;
			}
			while(!dq.isEmpty() && p.m>dq.peekLast().m) dq.pollLast();
			if(dq.isEmpty()) ans[p.in] = -1;
			else ans[p.in]= dq.peekLast().in; 
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
