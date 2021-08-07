package dmopc17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IntimidatingArrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Query implements Comparable<Query>{
		int id, l, r;
		public Query(int id, int l, int r) {
			this.id = id;
			this.l = l;
			this.r = r;
		}
		public int compareTo(Query other) {
			return Integer.compare(other.l, this.l);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		int[]arr = new int[N];
		Query[]query = new Query[Q];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		for(int i = 0; i<Q; i++) {
			query[i] = new Query(i, readInt(), readInt());
		}
		Arrays.sort(query);
		int cur = N; // the left ptr of the array 'arr'
		int idx = N-1; // the left most empty spot in 'stack'
		int[]stack = new int[N];
		int[]ans = new int[Q];
		for(int i = 0; i<Q; i++) {
			int l = query[i].l-1, r = query[i].r-1;
			//System.out.println("l:"+l+" r: "+r);
			while(cur>l) {
				cur--;
				while(idx+1<arr.length && arr[cur]>arr[stack[idx+1]]) {
					idx++;
				}
				stack[idx] = cur;
				idx--;
			}
			int u = Arrays.binarySearch(stack, idx+1, N, r);
			if(u<0) {
				u = -u-1;
				ans[query[i].id] = u-idx-1;
			} else {
				ans[query[i].id] = u-idx;
			}
			//System.out.println("u:"+u+" idx:"+idx);
			//System.out.println(Arrays.toString(stack));
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
