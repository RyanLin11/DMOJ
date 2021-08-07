package dmopc14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.*;

public class SelectiveCutting {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Query implements Comparable<Query>{
		int index, val, l, r;
		public Query(int index, int val, int l, int r) {
			this.index = index;
			this.val = val;
			this.l = l;
			this.r = r;
		}
		public int compareTo(Query other) {
			return Integer.compare(other.val, this.val);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt();
		ArrayList<Integer>[]list = new ArrayList[20001];
		for(int i = 0; i<list.length; i++) list[i] = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			list[readInt()].add(i+1);
		}
		int Q = readInt();
		Query[]q = new Query[Q];
		for(int i = 0; i<Q; i++) {
			int l = readInt(), r = readInt(), a = readInt();
			q[i] = new Query(i, a, l+1, r+1);
		}
		Arrays.sort(q);
		int[]bit = new int[N+1];
		int[]ans = new int[Q];
		int cur = list.length-1;
		for(int i = 0; i<Q; i++) {
			while(cur>=q[i].val) {
				for(int j = 0; j<list[cur].size(); j++) {
					update(bit, cur, list[cur].get(j));
				}
				cur--;
			}
			ans[q[i].index] = query(bit, q[i].l, q[i].r);
		}
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	public static void update(int[]bit, int val, int pos) {
		for(int i = pos; i<bit.length; i+=i&(-i)) {
			bit[i]+=val;
		}
	}
	public static int sum(int[]bit, int pos) {
		int sum = 0;
		for(int i = pos; i>0; i-=i&(-i)) {
			sum+=bit[i];
		}
		return sum;
	}
	public static int query(int[]bit, int l, int r) {
		return sum(bit,r)-sum(bit,l-1);
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
