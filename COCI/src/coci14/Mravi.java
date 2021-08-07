package coci14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Mravi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pipe {
		int v;
		int flow;
		boolean power;
		public Pipe(int v, int flow, boolean power) {
			this.v = v;
			this.flow = flow;
			this.power = power;
		}
	}
	static ArrayList<Pipe>[]list;
	static int[]leaf;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		list = new ArrayList[n+1];
		leaf = new int[n+1];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<n-1; i++) {
			int u = readInt();
			int v = readInt();
			int flow = readInt();
			boolean power = readInt()==1;
			list[u].add(new Pipe(v, flow, power));
		}
		for(int i = 1; i<=n; i++) {
			leaf[i] = readInt();
		}
		System.out.println(recurse(1));
	}
	public static double recurse(int u) {
		if(leaf[u]!=-1) return leaf[u];
		double minflow = 0;
		for(Pipe p: list[u]) {
			if(p.power) {
				minflow = Math.max(minflow, Math.sqrt(recurse(p.v))/(p.flow/100.0));
			} else {
				minflow = Math.max(minflow, recurse(p.v)/(p.flow/100.0));
			}
		}
		return minflow;
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
