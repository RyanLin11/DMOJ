package icpc2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;

public class Shopping {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Interval implements Comparable<Interval> {
		int id, l, r;
		long val;
		public Interval(int id, long val, int l, int r) {
			this.id = id;
			this.val = val;
			this.l = l;
			this.r = r;
		}
		public int compareTo(Interval other) {
			return Integer.compare(this.l, other.l);
		}
	}
	static class Pair implements Comparable<Pair>{
		int id, r;
		long val;
		public Pair(int id, long val, int r) {
			this.id = id;
			this.val = val;
			this.r = r;
		}
		public int compareTo(Pair other) {
			return Long.compare(other.val, this.val);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		PriorityQueue<Interval>left = new PriorityQueue<>();
		PriorityQueue<Pair>right = new PriorityQueue<>();
		long[]arr = new long[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readLong();
		}
		for(int i = 0; i<Q; i++) {
			left.add(new Interval(i, readLong(), readInt()-1, readInt()-1));
		}
		long[]ans = new long[Q];
		for(int i = 0; i<N; i++) {
			while(!left.isEmpty() && left.peek().l==i) {
				Interval in = left.poll();
				right.add(new Pair(in.id, in.val, in.r));
			}
			ArrayList<Pair>tmp = new ArrayList<>();
			while(!right.isEmpty() && right.peek().val>=arr[i]) {
				tmp.add(right.poll());
			}
			for(Pair p: tmp) {
				if(p.r<i) {
					ans[p.id] = p.val;
				} else {
					p.val = p.val % arr[i];
					right.add(p);
				}
			}
		}
		for(Pair p: right) {
			ans[p.id] = p.val; 
		}
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
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
