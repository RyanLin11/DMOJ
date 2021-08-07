package fhc15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class LazySort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt();
			Deque<Integer>orig = new LinkedList<>();
			Deque<Integer>orig2 = new LinkedList<>();
			for(int j = 0; j<N; j++) {
				int x = readInt();
				orig.offerLast(x);
				orig2.offerLast(x);
			}
			boolean flag = true;
			Deque<Integer>fin = new LinkedList<>();
			for(int j = 0; j<N; j++) {
				if(fin.isEmpty()) {
					fin.offerFirst(orig.pollFirst());
				} else if(orig.peekFirst()==fin.peekFirst()-1) {
					fin.offerFirst(orig.pollFirst());
				} else if(orig.peekFirst()==fin.peekLast()+1) {
					fin.offerLast(orig.pollFirst());
				} else if(orig.peekLast()==fin.peekFirst()-1) {
					fin.offerFirst(orig.pollLast());
				} else if(orig.peekLast()==fin.peekLast()+1){
					fin.offerLast(orig.pollLast());
				} else {
					flag = false;
					break;
				}
			}
			boolean flag2 = true;
			Deque<Integer>fin2 = new LinkedList<>();
			for(int j = 0; j<N; j++) {
				if(fin2.isEmpty()) fin2.offerFirst(orig2.pollLast());
				else if(orig2.peekFirst()==fin2.peekFirst()-1) {
					fin2.offerFirst(orig2.pollFirst());
				} else if(orig2.peekFirst()==fin2.peekLast()+1) {
					fin2.offerLast(orig2.pollFirst());
				} else if(orig2.peekLast()==fin2.peekFirst()-1) {
					fin2.offerFirst(orig2.pollLast());
				} else if(orig2.peekLast()==fin2.peekLast()+1){
					fin2.offerLast(orig2.pollLast());
				} else {
					flag2 = false;
					break;
				}
			}
			if(flag || flag2) System.out.println("Case #"+(i+1)+": yes");
			else System.out.println("Case #"+(i+1)+": no");
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
