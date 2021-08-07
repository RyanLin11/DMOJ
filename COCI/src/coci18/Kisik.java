package coci18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Kisik {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
		int w, h;
		public Pair(int w, int h) {
			this.w = w;
			this.h = h;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.h, other.h);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		PriorityQueue<Integer>wt = new PriorityQueue<>();
		PriorityQueue<Pair>p = new PriorityQueue<>();
		for(int i = 0; i<N; i++) {
			p.offer(new Pair(readInt(), readInt()));
		}
		long sum = 0;
		long ans = Long.MAX_VALUE;
		while(!p.isEmpty()) {
			int x = p.peek().h;
			while(!p.isEmpty() && p.peek().h==x) {
				if(wt.size()<K) {
					wt.add(-p.peek().w);
					sum += p.peek().w;
				} else if(p.peek().w<-wt.peek()) {
					sum -= -wt.peek();
					wt.poll();
					wt.add(-p.peek().w);
					sum += p.peek().w;
				}
				p.poll();
			}
			if(wt.size()==K) ans = Math.min(ans, sum * x);
		}
		System.out.println(ans);
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
