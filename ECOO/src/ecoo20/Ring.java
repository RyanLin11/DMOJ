package ecoo20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Stack;
import java.util.Arrays;

public class Ring {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			long x = 0;
			long[]factor = new long[n]; Arrays.fill(factor, 1);
			long[]add = new long[n];
			HashMap<String,Integer>map = new HashMap<>();
			Stack<Integer>stack = new Stack<>();
			for(int j = 0; j<n; j++) {
				String op = next();
				if(op.equals("FUN")) {
					String s = next();
					map.put(s, map.size());
					stack.push(map.get(s));
				} else if(op.equals("ADD")) {
					int y = readInt();
					if(!stack.isEmpty()) {
						add[stack.peek()]+=y;
					} else {
						x+=y;
					}
				} else if(op.equals("SUB")) {
					int y = readInt();
					if(!stack.isEmpty()) {
						add[stack.peek()]-=y;
					} else {
						x-=y;
					}
				} else if(op.equals("MULT")) {
					int y = readInt();
					if(!stack.isEmpty()) {
						add[stack.peek()]*=y;
						factor[stack.peek()]*=y;
					} else {
						x*=y;
					}
				} else if(op.equals("END")) {
					stack.pop();
				} else if(op.equals("CALL")) {
					String s = next();
					if(!stack.isEmpty()) {
						add[stack.peek()]*=factor[map.get(s)];
						add[stack.peek()]%=mod;
						add[stack.peek()]+=add[map.get(s)];
						factor[stack.peek()]*=factor[map.get(s)];
					} else {
						x*=factor[map.get(s)];
						x%=mod;
						x+=add[map.get(s)];
					}
				}
				x=(x+mod)%mod;
				if(!stack.isEmpty()) {
					add[stack.peek()]=(add[stack.peek()]+mod)%mod;
					factor[stack.peek()]=(factor[stack.peek()]+mod)%mod;
				}
			}
			System.out.println(x%mod);
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
