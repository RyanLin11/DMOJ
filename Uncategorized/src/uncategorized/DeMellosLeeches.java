package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class DeMellosLeeches {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair> {
		int id, x, v;
		public Pair(int id, int x, int v) {
			this.id = id;
			this.x = x;
			this.v = v;
		}
		public int compareTo(Pair other) {
			return Integer.compare(this.x, other.x);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[]arr = new int[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = readInt();
		}
		int Q = readInt();
		int[]bit = new int[Q+1];
		PriorityQueue<Pair>pq = new PriorityQueue<>();
		for(int i = 1; i<=Q; i++) {
			int l = readInt(), r = readInt();
			pq.add(new Pair(i, l-1, 1));
			pq.add(new Pair(i, r, -1));
		}
		//int lim = (int)Math.floor(Math.log(N)/Math.log(2));
		int lim = 30;
		int[]cnt = new int[Q+1];
		for(int i = 0; i<N; i++) {
			while(!pq.isEmpty() && pq.peek().x == i) {
				Pair p = pq.poll();
				update(bit, p.id, p.v);
			}
			int ans = 0;
			int val = arr[i];
			for(int j = lim; j>=0; j--) {
				int idx = ans|(1<<j);
				if(idx<bit.length && bit[idx] <= val) {
					ans = idx;
					val -= bit[idx];
				}
			}
			if(ans+1 < bit.length) {
				cnt[ans+1]++;
			}
		}
		for(int i = 1; i<cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
	public static void update(int[]bit, int x, int v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] += v;
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
