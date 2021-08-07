package olympiads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class ReduceSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		Stack<Integer>st = new Stack<>();
		long cost = 0;
		for(int i = 0; i<N; i++) {
			int x = readInt();
			while(!st.isEmpty() && st.peek()<=x) {
				st.pop();
				if(!st.isEmpty() && st.peek()<=x) cost+=st.peek();
				else cost+=x;
			}
			st.push(x);
		}
		st.pop();
		while(!st.isEmpty()) {
			cost+=st.pop();
		}
		System.out.println(cost);
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
