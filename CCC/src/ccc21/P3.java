package ccc21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class P3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
		int x, v;
		public Pair(int x, int v){
			this.x = x;
			this.v = v;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.x, other.x);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(next());
		int[]p = new int[N];
		int[]w = new int[N];
		int[]d = new int[N];
		int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
		PriorityQueue<Pair>pq = new PriorityQueue<>();
		int inc = 0;
		for(int i = 0; i<N; i++) {
			p[i] = Integer.parseInt(next());
			w[i] = Integer.parseInt(next());
			d[i] = Integer.parseInt(next());
			pq.offer(new Pair(p[i] - d[i], w[i]));
			pq.offer(new Pair(p[i] + d[i], w[i]));
			inc += -w[i];
			l = Math.min(l, p[i]);
			r = Math.max(r, p[i]);
		}
		//compute at the start
		long sum = 0;
		for(int i = 0; i<p.length; i++) {
			sum += (int)Math.ceil(Math.max((Math.abs(p[i] - l) - d[i]),0)*(double)w[i]);
		}
		//start running
		long minsum = sum;
		int last = l;
		PriorityQueue<Pair>other = new PriorityQueue<>();
		while(pq.peek().x < l) {
			other.add(pq.poll());
		}
		while(!pq.isEmpty() && pq.peek().x <= r) {
			int prev = pq.peek().x;
			sum += inc * Math.max(0, prev - last - 1);
			while(!pq.isEmpty() && pq.peek().x <= prev) {
				inc += pq.poll().v;
			}
			while(!other.isEmpty()) {
				inc += other.poll().v;
			}
			sum += inc;
			System.out.println(prev+" "+inc);
			last = prev;
			minsum = Math.min(minsum, sum);
		}
		//minsum = Math.min(minsum, sum + inc*())
		/*long minsum = sum;
		for(int i = l; i<=r; i++) {
			while(!pq.isEmpty() && pq.peek().x <= i) {
				inc += pq.poll().v;
			}
			System.out.println(i+" "+inc);
			sum += inc;
			minsum = Math.min(minsum, sum);
		}*/
		System.out.println(minsum);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
}
