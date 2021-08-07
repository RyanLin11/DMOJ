package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class MollyAndFlyingDrones {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		Stack<Integer>st = new Stack<>();
		Stack<Integer>in = new Stack<>();
		long[]psa = new long[1000001];
		for(int i = 0; i<N; i++) {
			int x = readInt();
			while(!st.isEmpty() && st.peek()>x) {
				int val = st.pop();
				int idx = in.pop();
				if(in.size()>0) psa[val] += ((long)i - idx) * (idx - in.peek());
				else psa[val] += ((long)i - idx) * (idx + 1);
			}
			st.push(x);
			in.push(i);
		}
		while(!st.isEmpty()) {
			int val = st.pop();
			int idx = in.pop();
			if(in.size()>0) psa[val] += ((long)N - idx) * (idx - in.peek());
			else psa[val] += ((long)N - idx) * (idx + 1);
		}
		for(int i = 1; i<psa.length; i++) {
			psa[i] += psa[i-1];
		}
		for(int i = 0; i<Q; i++) {
			int l = readInt(), r = readInt();
			System.out.println(psa[r]-psa[l-1]);
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
