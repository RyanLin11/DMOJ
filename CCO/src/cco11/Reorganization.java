package cco11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Reorganization {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		TreeMap<Integer, Boolean>map = new TreeMap<>();
		map.put(readInt(), false);
		boolean flag = true;
		for(int i = 1; i<n; i++) {
			try {
				int x = readInt();
				int floor = map.floorKey(x);
				if(map.get(floor)) {
					map.remove(floor);
				} else {
					map.put(floor, true);
				}
				map.put(x, false);
			} catch (NullPointerException e) {
				flag = false;
				break;
			}
		}
		System.out.println(flag?"YES":"NO");
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
