package cco14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Fuel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int cost, val;
		public Pair(int val, int cost) {
			this.val = val;
			this.cost = cost;
		}
		public int compareTo(Pair other) {
			if(this.cost<other.cost)return -1;
			else if(this.cost>other.cost)return 1;
			else return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int p = readInt();
		int s = 0;
		ArrayList<Pair>list = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			int x = readInt();
			int y = readInt();
			if(i==p-1) s+=x;
			else if(x-y>=0) list.add(new Pair(x-y,y));
		}
		Collections.sort(list);
		int cnt = 1;
		for(Pair a: list) {
			if(a.cost>s) break;
			s+=a.val;
			cnt++;
		}
		System.out.println(s);
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
