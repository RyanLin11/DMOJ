package gcc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class WatchingAnime {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), a = readInt(), b = readInt();
		TreeMap<Integer, Long>map = new TreeMap<>();
		for(int i = 0; i<a; i++) {
			int x = readInt(), y = readInt()+1;
			if(map.containsKey(x)) {
				map.put(x, map.get(x)+1);
			} else {
				map.put(x, 1L);
			}
			if(map.containsKey(y)) {
				map.put(y, map.get(y)-1);
			} else {
				map.put(y, -1L);
			}
		}
		for(int i = 0; i<b; i++) {
			int x = readInt(), y = readInt()+1;
			if(map.containsKey(x)) {
				map.put(x, map.get(x)-100000);
			} else {
				map.put(x, -100000L);
			}
			if(map.containsKey(y)) {
				map.put(y, map.get(y)+100000);
			} else {
				map.put(y, 100000L);
			}
		}
		long total = 0;
		int hours = 0;
		int prev = 0;
		for(int i: map.keySet()) {
			if(total>0) hours += i-prev;
			total += map.get(i);
			prev = i;
		}
		System.out.println(hours);
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
