package ccc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gates {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		int g = readInt();
		int p = readInt();
		arr = new int[g+1];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i;
		}
		int planes = 0;
		boolean full = false;
		for(int i = 0; i<p; i++) {
			int n = readInt();
			if(!full) {
				int x = find(n);
				if(x==-1) {
					full = true;
				} else {
					arr[x] = arr[x-1];
					planes++;
				}
			}
		}
		System.out.println(planes);
	}
	public static int find(int x) {
		if(arr[x]==x) {
			if(arr[x]==0) return -1;
			return x;
		}
		return arr[x] = find(arr[x]);
	}
	public static String next () throws IOException {
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
