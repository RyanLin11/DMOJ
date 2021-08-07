package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Sawmill {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Integer>e = new ArrayList<>();
		ArrayList<Integer>l = new ArrayList<>();
		for(int i = 0; i<n; i++) e.add(readInt());
		for(int i = 0; i<n; i++) l.add(readInt());
		Collections.sort(e); Collections.sort(l);
		long energy = 0;
		for(int i = 0; i<n; i++) {
			energy+=e.get(i)*l.get(l.size()-i-1);
		}
		System.out.println(energy);
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
