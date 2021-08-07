package ccc21sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class LunchConcert {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Friend implements Comparable<Friend> {
		long p, w;
		public Friend(long p, long w) {
			this.p = p;
			this.w = w;
		}
		public int compareTo(Friend other) {
			return Long.compare(this.p, other.p);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt();
		long[]p = new long[N];
		long[]w = new long[N];
		long[]d = new long[N];
		long delta = 0;
		PriorityQueue<Friend>pq = new PriorityQueue<>();
		//Add end points of friend range, sorted from left to right
		for(int i = 0; i<N; i++) {
			p[i] = readInt(); w[i] = readInt(); d[i] = readInt();
			pq.offer(new Friend(p[i]-d[i], w[i]));
			pq.offer(new Friend(p[i]+d[i], w[i]));
			delta += -w[i];
		}
		//Find the value at the most leftmost end point
		long c = pq.peek().p;
		long time = 0;
		for(int i = 0; i<N; i++) {
			time += Math.max(0, Math.abs(p[i] - c) - d[i]) * w[i];
		}
		//Find the value at each endpoint
		long min = Long.MAX_VALUE;
		while(!pq.isEmpty()) {
			Friend f = pq.poll();
			time += delta * (f.p - c);
			delta += f.w;
			c = f.p;
			min = Math.min(min, time);
		}
		System.out.println(min);
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
