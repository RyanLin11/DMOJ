package utsopen21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class StateTaxes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
		int a, b, q;
		public Pair(int a, int b, int q) {
			this.a = a;
			this.b = b;
			this.q = q;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.a, other.a);
		}
	}
	static long[]bit, bitx;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		long[]arr = new long[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		PriorityQueue<Pair>bonus = new PriorityQueue<>();
		PriorityQueue<Pair>rev = new PriorityQueue<>();
		for(int i = 1; i<=Q; i++) {
			int d = readInt();
			if(d == 1) {
				int l = readInt()-1, r = readInt()-1, x = readInt();
				bonus.add(new Pair(l, x, i));
				bonus.add(new Pair(r+1, -x, i));
			} else {
				int l = readInt()-1, r = readInt()-1;
				rev.add(new Pair(l, 1, i));
				rev.add(new Pair(r+1, -1, i));
			}
		}
		bit = new long[Q+1];
		bitx = new long[Q+1]; //tracks when salaries are called
		long cur = 0;
		for(int i = 0; i<arr.length; i++) {
			//remove revenue calls
			//
			while(!bonus.isEmpty() && bonus.peek().a == i) {
				Pair p = bonus.poll();
				cur += (query(bitx, Q) - query(bitx, p.q))* p.b;
				update(bit, p.q, p.b);
			}
			while(!rev.isEmpty() && rev.peek().a == i) {
				Pair p = rev.poll();
				update(bitx, p.q, p.b);
				cur += query(bit, p.q) * p.b;
			}
			System.out.print((cur+query(bitx, Q)*arr[i])+" ");
		}
		System.out.println();
	}
	public static void update(long[]bit, int x, int v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] += v;
		}
	}
	public static long query(long[]bit, int x) {
		long sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
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
