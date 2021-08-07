package coi16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Patrik {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Stack<Integer>st = new Stack<>();
		Stack<Integer>freq = new Stack<>();
		int n = readInt();
		long cnt = 0;
		for(int i = 0; i<n; i++) {
			int x = readInt();
			int y = 0;
			while(!st.isEmpty()) {
				if(st.peek()<x) {
					st.pop();
					cnt+=freq.pop();
				} else if(st.peek()==x) {
					st.pop();
					y = freq.pop();
					cnt+=y;
				} else {
					cnt++;
					break;
				}
			}
			st.push(x);
			freq.push(y+1);
		}
		System.out.println(cnt);
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
