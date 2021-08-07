package dpmg18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.HashSet;

public class MusicalChairs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		int[]map = new int[N+1];
		HashSet<Integer>set = new HashSet<>();
		HashSet<Integer>st = new HashSet<>();
		for(int i = 0; i<K; i++) {
			set.add(readInt()-1);
		}
		for(int i = 0; i<K+1; i++) {
			int x = readInt()-1;
			st.add(x);
			map[x] = i+1;
		}
		Stack<Integer>s = new Stack<>();
		int i = 0;
		while(!set.isEmpty()) {
			if(st.contains(i)) {
				s.push(i);
				st.remove(i);
			}
			if(set.contains(i) && !s.isEmpty()) {
				set.remove(i);
				s.pop();
			}
			i = (i+1)%N;
		}
		System.out.println(map[s.pop()]);
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
