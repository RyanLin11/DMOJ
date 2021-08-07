package coci13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Lopov {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]m,v;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		m = new int[N];
		v = new int[N];
		Integer[]idx = new Integer[N];
		for(int i = 0; i<N; i++) idx[i] = i;
		int[]c = new int[K];
		for(int i = 0; i<N; i++) {
			m[i] = readInt();
			v[i] = readInt();
		}
		for(int i = 0; i<K; i++) {
			c[i] = readInt();
		}
		Arrays.sort(idx, new sortByMass());
		Arrays.sort(c);
		PriorityQueue<Integer>pq = new PriorityQueue<>(new sortReverseOrder());
		long mass = 0;
		for(int i = 0, j = 0; i<c.length; i++) {
			while(j<N && m[idx[j]]<=c[i]) {
				pq.offer(v[idx[j]]);
				j++;
			}
			if(!pq.isEmpty()) mass += pq.poll();
		}
		System.out.println(mass);
	}
	public static class sortByMass implements Comparator<Integer>{
		public int compare(Integer x, Integer y) {
			return Integer.compare(m[x], m[y]);
		}
	}
	public static class sortReverseOrder implements Comparator<Integer>{
		public int compare(Integer x, Integer y) {
			return Integer.compare(y, x);
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
