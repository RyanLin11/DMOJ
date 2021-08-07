package ccc19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Tourism {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		int[]arr = new int[N];
		int[]dp = new int[N%K+1];
		int[]next = new int[N%K+1];
		
		int rem = K - N%K;
		Deque<Integer>max = new LinkedList<>();
		int pt = 0;
		int y = 0;
		int cmax = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
			while(!max.isEmpty() && max.peekLast()<arr[i])  max.pollLast();
			max.offerLast(arr[i]);
			int pos = i%K; //position = i%K
			if(pos>=rem-1) {
				cmax = Math.max(cmax, arr[i]);
				if(cmax<=pt) {
					dp[pos] = y;
				} else {
					dp[pos] = (y-pt) + cmax;
				}
				if(pos==K-1) {
					
					int prev = dp[pos-rem+1];
					int nxt = next[pos-rem+1];
					int xint = y - prev;
					if(xint<=pt) { //up intersect top
						pt = xint;
					} else if(prev+nxt>=y) { //up does not intersect top
						pt = prev+nxt - (y-pt);
						y = prev+nxt;
					}
				}
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
