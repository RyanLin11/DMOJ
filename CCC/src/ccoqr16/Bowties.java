package ccoqr16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;

public class Bowties {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt();
		TreeMap<Integer,ArrayList<Integer>>row = new TreeMap<>();
		HashMap<Integer,Integer>total = new HashMap<>();
		HashMap<Integer,Integer>cur = new HashMap<>();
		for(int i = 0; i<N; i++) {
			int r = readInt(), c = readInt();
			if(!row.containsKey(r)) {
				row.put(r, new ArrayList<>());
			}
			row.get(r).add(c);
			if(!total.containsKey(c)) {
				total.put(c, 1);
			} else {
				total.put(c, total.get(c)+1);
			}
		}
		long cnt = 0;
		for(int r: row.keySet()) {
			Collections.sort(row.get(r));
			for(int i = 0; i<row.get(r).size(); i++) {
				int c = row.get(r).get(i);
				if(!cur.containsKey(c)) cur.put(c, 0);
				cnt += (long)cur.get(c) * (total.get(c)-cur.get(c)-1) * i * (row.get(r).size()-i-1);
				cur.put(c, cur.get(c)+1);
			}
		}
		cnt*=2;
		System.out.println(cnt);
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
