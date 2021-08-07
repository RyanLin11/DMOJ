package cco12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class ChooseYourOwnArithmetic {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int W = readInt();
		int D = readInt();
		int[]digit = new int[D];
		HashSet<Integer>set = new HashSet<>();
		for(int i = 0; i<digit.length; i++) {
			digit[i] = readInt();
			set.add(digit[i]);
		}
		int V = readInt();
		int[]target = new int[V];
		for(int i = 0; i<target.length; i++) {
			target[i] = readInt();
		}
		for(int i = 0; i<W; i++) {
			HashSet<Integer>tmp = new HashSet<>();
			for(int x: set) {
				for(int j = 0; j<digit.length; j++) {
					tmp.add(x+digit[j]);
					tmp.add(x*digit[j]);
				}
			}
			set = tmp;
		}
		for(int i = 0; i<target.length; i++) {
			if(set.contains(target[i])) {
				System.out.println("Y");
			} else {
				System.out.println("N");
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
