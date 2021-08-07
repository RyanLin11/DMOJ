package coci09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Kutevi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		HashSet<Integer>cycle = new HashSet<>();
		HashSet<Integer>set = new HashSet<>();
		HashSet<Integer>temp = new HashSet<>();
		for(int i = 0; i<n; i++) {
			int x = readInt();
			for(int j = x; !cycle.contains(j%360) ; j+=x) {
				cycle.add(j%360);
			}
			for(int y: set) {
				for(int z: cycle) {
					temp.add((y+z)%360);
					temp.add((y-z+360)%360);
					temp.add((y-x+360)%360);
				}
			}
			set.addAll(temp);
			set.addAll(cycle);
			temp.clear();
			cycle.clear();
		}
		for(int j = 0; j<k; j++) {
			System.out.println(set.contains(readInt())?"YES":"NO");
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
