package coci07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Poklon {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]bit;
	static ArrayList<Interval>list;
	static class Interval implements Comparable<Interval> {
		int id, l, r, v;
		public Interval(int id, int l, int r) {
			this.id = id;
			this.l = l;
			this.r = r;
			this.v = 0;
		}
		public int compareTo(Interval other) {
			if(this.r<other.r) {
				return 1;
			} else if(this.r>other.r) {
				return -1;
			} else {
				return Integer.compare(this.l, other.l);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt();
		list = new ArrayList<>();
		bit = new int[1000001];
		Arrays.fill(bit, -1);
		for(int i = 0; i<N; i++) {
			list.add(new Interval(i, readInt(), readInt()));
		}
		Collections.sort(list);
		int[]pre = new int[N];
		int idx = 0;
		for(Interval i: list) {
			pre[idx] = query2(i.l);
			if(pre[idx]<0) {
				i.v = 1;
			} else {
				i.v = list.get(pre[idx]).v+1;
			}
			update2(i.l, idx);
			idx++;
		}
		int max = 0;
		int maxin = 0;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).v>max) {
				max = list.get(i).v;
				maxin = i;
			}
		}
		System.out.println(max);
		Stack<Integer>st = new Stack<>();
		for(int i = maxin; i>=0; i=pre[i]) {
			st.push(i);
		}
		while(!st.isEmpty()) {
			int id = st.pop();
			System.out.println(list.get(id).l+" "+list.get(id).r);
		}
	}
	public static void update(int x, int v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i] = Math.max(bit[i], v);
		}
	}
	public static void update2(int x, int v) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			if(bit[i]<0 || list.get(v).v > list.get(bit[i]).v) {
				bit[i] = v;
			}
		}
	}
	public static int query(int x) {
		int max = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			max = Math.max(max, bit[i]);
		}
		return max;
	}
	public static int query2(int x) {
		int max = 0;
		int maxin = -1;
		for(int i = x; i>0; i-=i&(-i)) {
			if(bit[i]<0) continue;
			if(maxin<0 || list.get(bit[i]).v>max) {
				maxin = bit[i];
				max = list.get(bit[i]).v;
			}
		}
		return maxin;
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
