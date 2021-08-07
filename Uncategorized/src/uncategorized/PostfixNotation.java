package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class PostfixNotation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String[]s = readLine().split(" ");
		Stack<Double>st = new Stack<>();
		for(int i = 0; i<s.length; i++) {
			if(s[i].equals("+")) {
				double y = st.pop(), x = st.pop();
				st.push(x+y);
			} else if(s[i].equals("-")) {
				double y = st.pop(), x = st.pop();
				st.push(x-y);
			} else if(s[i].equals("*")) {
				double y = st.pop(), x = st.pop();
				st.push(x*y);
			} else if(s[i].equals("/")) {
				double y = st.pop(), x = st.pop();
				st.push(x/y);
			} else if(s[i].equals("%")) {
				double y = st.pop(), x = st.pop();
				st.push(x%y);
			} else if(s[i].equals("^")) {
				double y = st.pop(), x = st.pop();
				st.push(Math.pow(x, y));
			} else {
				st.push(Double.parseDouble(s[i]));
			}
		}
		System.out.println(st.pop());
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
