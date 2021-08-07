package dmopc18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DrHenriAndLabData {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Query implements Comparable<Query>{
		int id, l, r, k;
		public Query(int id, int l, int r, int k) {
			this.id = id;
			this.l = l;
			this.r = r;
			this.k = k;
		}
		public int compareTo(Query other) {
			return Integer.compare(other.k, this.k);
		}
	}
	static class Pair implements Comparable<Pair>{
		int val, idx;
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
		public int compareTo(Pair other) {
			return Integer.compare(other.val, this.val);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		long[]psa = new long[N+1];
		Pair[]pair = new Pair[N];
		for(int i = 1; i<psa.length; i++) {
			int x = readInt();
			pair[i-1] = new Pair(x, i);
			psa[i] = psa[i-1] + x;
		}
		Arrays.sort(pair);
		Query[]query = new Query[Q];
		for(int i = 0; i<Q; i++) {
			query[i] = new Query(i,readInt(), readInt(), readInt());
		}
		Arrays.sort(query);
		long[]bit = new long[N+1];
		int pidx = 0;
		long[]ans = new long[Q];
		for(int i = 0; i<Q; i++) {
			while(pidx<N && pair[pidx].val>=query[i].k) {
				update(bit, pair[pidx].idx, pair[pidx].val);
				pidx++;
			}
			ans[query[i].id] =  2*query(bit, query[i].l, query[i].r) - psa[query[i].r] + psa[query[i].l-1];
		}
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	public static void update(long[]bit, int pos, int val) {
		for(int i = pos; i<bit.length; i+=i&(-i)) {
			bit[i] += val;
		}
	}
	public static long sum(long[]bit, int pos) {
		long sum = 0;
		for(int i = pos; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
	}
	public static long query(long[]bit, int l, int r) {
		return sum(bit, r) - sum(bit, l-1);
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
