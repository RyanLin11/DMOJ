package dmpg16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class PizzaBag {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[]psa = new long[n+k+1];
		for(int i = 1; i<n+1; i++) {
			psa[i]=psa[i-1]+readInt();
		}
		for(int i = 1; i<=k; i++) {
			psa[i+n]=psa[n]+psa[i];
		}
		Deque<Long>dq = new LinkedList<>();
		long max = 0;
		for(int i = 1; i<psa.length; i++) {
			if(i-k-1>=0 && !dq.isEmpty() && dq.peekFirst()==psa[i-k-1]) dq.pollFirst();
			while(!dq.isEmpty() && dq.peekLast()>psa[i-1]) dq.pollLast();
			dq.offerLast(psa[i-1]);
			max = Math.max(max, psa[i]-dq.peekFirst());
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
