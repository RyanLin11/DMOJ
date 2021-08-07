package dpmg18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class MimiAndKuteness {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[]arr = new long[n+1];
		for(int i = 1; i<arr.length; i++) {
			arr[i] = readInt()+arr[i-1];
		}
		Stack<Long>s = new Stack<>();
		long x = 0;
		for(int l = 0, r=n; l<r; l++, r--) {
			x+=arr[r]-arr[l];
			System.out.println(x);
			s.push(x);
		}
		if(n%2==1) s.pop();
		while(!s.isEmpty()) {
			System.out.println(s.pop());
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
