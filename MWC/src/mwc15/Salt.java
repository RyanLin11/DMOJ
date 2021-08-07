package mwc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;

public class Salt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();int q = readInt();
		HashMap<Integer,Integer>map = new HashMap<>();
		HashMap<Integer,Integer>x = new HashMap<>();
		HashMap<Integer,Integer>y = new HashMap<>();
		HashMap<Integer, HashSet<Integer>>coord = new HashMap<>();
		for(int i = 0; i<n; i++) {
			int x1 = readInt(), y1 = readInt();
			if(!coord.containsKey(x1))coord.put(x1, new HashSet<>());
			coord.get(x1).add(y1);
			if(x.containsKey(x1)) x.put(x1, x.get(x1)+1);
			else x.put(x1,1);
			if(y.containsKey(y1)) y.put(y1, y.get(y1)+1);
			else y.put(y1,1);
		}
		for(int i = 0; i<q; i++) {
			int a = readInt();
			if(a==1) {
				int x1 = readInt(), y1 = readInt();
				if(coord.containsKey(x1) && coord.get(x1).contains(y1)) {
					System.out.println("salty");
				} else {
					System.out.println("bland");
				}
			} else {
				char c = readCharacter();
				int f = readInt();
				if(c=='X') {
					if(x.containsKey(f)) {
						System.out.println(x.get(f));
					} else {
						System.out.println(0);
					}
				} else {
					if(y.containsKey(f)) {
						System.out.println(y.get(f));
					} else {
						System.out.println(0);
					}
				}
			}
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
