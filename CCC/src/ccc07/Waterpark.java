package ccc07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.*;

public class Waterpark {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparator<Pair>{
		int src, dest;
		public Pair(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
		public Pair() {
			
		}
		public int compare(Pair p1, Pair p2) {
			if(p1.dest<p2.dest) {
				return -1;
			} else if(p1.dest>p2.dest) {
				return 1;
			}
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList<Pair>list = new ArrayList<>();
		int a = readInt();
		int b = readInt();
		while(a!=0 && b!=0) {
			list.add(new Pair(a,b));
			a = readInt();
			b = readInt();
		}
		Collections.sort(list, new Pair());
		int[]v = new int[n+1];
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).src==1)v[list.get(i).dest]+=1;
			else v[list.get(i).dest]+=v[list.get(i).src];
		}
		System.out.println(v[n]);
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
