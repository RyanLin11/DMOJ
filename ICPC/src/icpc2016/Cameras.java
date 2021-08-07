package icpc2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Cameras {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), r = readInt();
		boolean[]set = new boolean[n];
		for(int i = 0; i<k; i++) {
			set[readInt()] = true;
		}
		Deque<Integer>deque = new LinkedList<>();
		int cnt = 0;
		for(int i = 0; i<n; i++) {
			if(!set[i]) deque.offerLast(i);
			if(!deque.isEmpty() && deque.peek()==i-r) deque.pollFirst();
			if(deque.size()>r-2) {
				deque.pollLast();
				cnt++;
			}
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
