package dmopc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class CarnivalPhantasm {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]dist;
	static class sortByDist implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			if(dist[a]<dist[b]) return -1;
			else if(dist[a]>dist[b]) return 1;
			else {
				if(a<b) return -1;
				else if(a>b) return 1;
				else return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int n = readInt(), s = readInt();
		dist = new int[n+1];
		for(int i = 1; i<dist.length; i++) {
			dist[i] = readInt();
		}
		TreeSet<Integer>[]set = new TreeSet[101];
		for(int i = 0; i<set.length; i++) set[i] = new TreeSet<>(new sortByDist());
		for(int i = 0; i<s; i++) {
			int a = readInt(), b = readInt();
			set[b].add(a);
		}
		int q = readInt();
		for(int i = 0; i<q; i++) {
			char c = readCharacter();
			int x = c=='Q'?0:readInt();
			int k = readInt();
			if(c=='A') {
				set[k].add(x);
			} else if(c=='S') {
				set[k].remove(x);
			} else if(c=='E') {
				for(TreeSet<Integer> ts: set) {
					ts.remove(x);
				}
				dist[x] = k;
			} else {
				if(set[k].isEmpty()) System.out.println(-1);
				else System.out.println(set[k].first());
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
