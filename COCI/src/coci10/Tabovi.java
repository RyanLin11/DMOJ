package coci10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Tabovi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]p = new int[N];
		for(int i = 0; i<N; i++) {
			p[i] = readInt();
		}
		int[]k = new int[N];
		for(int i = 0; i<N; i++) {
			k[i] = readInt();
		}
		Stack<Integer>s = new Stack<>();
		int ans = 0;
		for(int i = 0; i<N; i++) {
			if(k[i]-p[i] >= 0) {
				int v = s.isEmpty()? 0: s.peek();
				if(v < k[i]-p[i]) {
					ans += Math.abs(k[i]-p[i] - Math.max(0, v));
				}
				while(!s.isEmpty() && s.peek()> k[i]-p[i]) {
					s.pop();
				}
				s.push(k[i]-p[i]);
			} else {
				int v = s.isEmpty()? 0: s.peek();
				if(v > k[i]-p[i]) {
					ans += Math.abs(k[i]-p[i] - Math.min(0, v));
				}
				while(!s.isEmpty() && s.peek() < k[i]-p[i]) {
					s.pop();
				}
				s.push(k[i]-p[i]);
			}
		}
		System.out.println(ans);
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
