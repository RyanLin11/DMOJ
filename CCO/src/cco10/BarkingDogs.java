package cco10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class BarkingDogs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int D = readInt();
		int[]w = new int[D];
		for(int i = 0; i<D; i++) {
			w[i] = readInt();
		}
		ArrayList<Integer>[]list = new ArrayList[D];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		int F = readInt();
		for(int i = 0; i<F; i++) {
			int x = readInt()-1, y = readInt()-1;
			list[x].add(y);
		}
		int T = readInt();
		int[]cnt = new int[D];
		ArrayList<Integer>[]bark = new ArrayList[T+1];
		for(int i = 0; i<bark.length; i++) bark[i] = new ArrayList<>();
		HashSet<Integer>busy = new HashSet<>();
		for(int i: list[0]) {
			if(!busy.contains(i)) {
				busy.add(i);
				if(w[i]<=T) {
					bark[w[i]].add(i);
					cnt[i]++;
				}
			}
		}
		cnt[0]++;
		for(int i = 1; i<=T; i++) {
			for(int j: bark[i]) {
				for(int k: list[j]) {
					if(!busy.contains(k)) {
						busy.add(k);
						if(i+w[k]<=T) {
							bark[i+w[k]].add(k);
							cnt[k]++;
						}
					}
				}
			}
			for(int j: bark[i]) {
				busy.remove(j);
			}
		}
		for(int i = 0; i<cnt.length; i++) {
			System.out.println(cnt[i]);
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
