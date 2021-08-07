package dmpg17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hackathons {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[]arr = new int[1000001];
		for(int i = 0; i<n; i++) {
			int w = readInt();
			int v = readInt();
			if(arr[w]!=0) arr[w] = Math.max(arr[w], v);
			else arr[w] = v;
		}
		for(int i = 1; i<arr.length; i++) {
			arr[i] = Math.max(arr[i-1],arr[i]);
		}
		int q = readInt();
		for(int i = 0; i<q; i++) {
			System.out.println(arr[readInt()]);
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
