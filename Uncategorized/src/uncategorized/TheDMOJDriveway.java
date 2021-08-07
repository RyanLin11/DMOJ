package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class TheDMOJDriveway {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt(), m = readInt();
		Deque<String>dq = new LinkedList<>();
		for(int i = 0; i<t; i++) {
			String s = next();
			if(next().equals("in")) {
				dq.offerLast(s);
			} else {
				if(dq.peekLast().equals(s)) dq.pollLast();
				if(dq.peekFirst().equals(s)&&m>0) {
					dq.pollFirst(); m--;
				}
			}
		}
		while(!dq.isEmpty()) {
			System.out.println(dq.pollFirst());
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
