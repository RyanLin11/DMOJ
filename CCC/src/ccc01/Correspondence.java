package ccc01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Correspondence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]hash1, hash2, xl, yl, pow;
	static int m, n;
	static int base = 131;
	public static void main(String[]args) throws IOException {
		m = readInt();
		n = readInt();
		hash1 = new int[n];
		hash2 = new int[n];
		xl = new int[n];
		yl = new int[n];
		pow = new int[m*n*20+1];
		pow[0] = 1;
		for(int i = 1; i<pow.length; i++) {
			pow[i] = pow[i-1]*base;
		}
		for(int i = 0; i<n; i++) {
			char[]c = next().toCharArray();
			for(int j = 0; j<c.length; j++) {
				hash1[i]+=(c[j]-'a'+1)*pow[j];
			}
			xl[i] = c.length;
		}
		for(int i = 0; i<n; i++) {
			char[]c = next().toCharArray();
			for(int j = 0; j<c.length; j++) {
				hash2[i]+=(c[j]-'a'+1)*pow[j];
			}
			yl[i] = c.length;
		}
		if(!f(0,0,0,0,new ArrayList<>())) {
			System.out.println("No solution.");
		}
	}
	public static boolean f(int x, int xlen, int y, int ylen, ArrayList<Integer>path) {
		if(x==y && x!=0) {
			System.out.println(path.size());
			for(int i: path) {
				System.out.println(i);
			}
			return true;
		}
		if(path.size()>=m) return false;
		for(int i = 0; i<n; i++) {
			path.add(i+1);
			if(f(x+hash1[i]*pow[xlen],xlen+xl[i], y+hash2[i]*pow[ylen], ylen+yl[i], path)) return true;
			path.remove(path.size()-1);
		}
		return false;
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
