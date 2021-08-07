package ecoo12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class SteamArithmetic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i<10; i++) {
			char[]c = readLine().toCharArray();
			Stack<Character>st = new Stack<>();
			Stack<Integer>si = new Stack<>();
			for(int j = 0; j<c.length; j++) {
				if(c[j]=='+'||c[j]=='-'||c[j]=='*'||c[j]=='q'||c[j]=='r') {
					st.push(c[j]);
				} else if(Character.isDigit(c[j])) {
					si.push(c[j]-48);
				} else if(c[j]==')') {
					char ch = st.pop(); int b = si.pop(), a = si.pop();
					switch(ch) {
					case '+':
						si.push(a+b);
						break;
					case '-':
						si.push(a-b);
						break;
					case '*':
						si.push(a*b);
						break;
					case 'q':
						si.push(a/b);
						break;
					case 'r':
						si.push(a%b);
						break;
					}
				}
			}
			System.out.println(si.pop());
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
