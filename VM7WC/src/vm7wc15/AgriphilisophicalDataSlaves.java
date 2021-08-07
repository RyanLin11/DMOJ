package vm7wc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class AgriphilisophicalDataSlaves {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[]list;
	static int[]val;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		val = new int[n+1];
		list = new ArrayList[n+1];
		for(int i = 0; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<n-1; i++) {
			list[readInt()].add(readInt());
		}
		for(int i = 0; i<n; i++) {
			val[i+1] = readInt();
		}
		arr = new int[n+1];
		int x = DFS(1);
		int max = 0;
		for(int i = 0; i<arr.length; i++) {
			max = Math.max(max, val[i]);
		}
		System.out.println(max);
	}
	
	public static int DFS(int u) {
		for(int v: list[u]) {
			val[u]+=DFS(v);
		}
		return val[u];
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
