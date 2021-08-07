package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Arrays;

public class FallingSnowflakes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]add, rem;
	static class Query implements Comparable<Query>{
		int a = 0, b = 0, c = 0, d = 0, t = 0, id = 0;
		char ch;
		public Query(int id, char ch, int a, int b, int t) {
			this.id = id;
			this.ch = ch;
			this.a = a;
			this.b = b;
			this.t = t;
		}
		public Query(int id, char ch, int a, int b, int c, int d, int t) {
			this.id = id;
			this.ch = ch;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.t = t;
		}
		public int compareTo(Query other) {
			return Integer.compare(this.t, other.t);
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), Q = readInt();
		int[]r = new int[M];
		int[]c = new int[M];
		add = new int[M];
		rem = new int[M];
		for(int i = 0; i<M; i++) {
			r[i] = readInt()+1; 
			c[i] = readInt()+1; 
			add[i] = readInt(); 
			rem[i] = readInt();
		}
		Integer[]start = new Integer[M];
		Integer[]end = new Integer[M];
		for(int i = 0; i<M; i++) {
			start[i] = i;
			end[i] = i;
		}
		Arrays.sort(start, new sortByStart());
		Arrays.sort(end, new sortByEnd());
		Query[]query = new Query[Q];
		int[][]bit = new int[N+1][N+1];
		for(int i = 0; i<Q; i++) {
			char ch = readCharacter();
			if(ch=='R'||ch=='C') {
				query[i] = new Query(i, ch, readInt()+1, readInt()+1, readInt());
			} else {
				query[i] = new Query(i, ch, readInt()+1, readInt()+1, readInt()+1, readInt()+1, readInt());
			}
		}
		Arrays.sort(query);
		int[]ans = new int[Q];
		int startidx = 0, endidx = 0;
		for(int i = 0; i<Q; i++) {
			//add all snow flakes that have begin time <= current time
			while(startidx<M && add[start[startidx]]<=query[i].t) {
				update(bit, r[start[startidx]], c[start[startidx]], 1);
				startidx++;
			}
			//remove all snow flakes that have end time <= current time
			while(endidx<M && rem[end[endidx]]<=query[i].t) {
				update(bit, r[end[endidx]], c[end[endidx]], -1);
				endidx++;
			}
			//query all remaining snow flakes
			if(query[i].ch=='R') {
				ans[query[i].id] = sumrow(bit, query[i].b)-sumrow(bit, query[i].a-1);
			} else if(query[i].ch=='C') {
				ans[query[i].id] = sumcol(bit, query[i].b)-sumcol(bit, query[i].a-1);
			} else {
				ans[query[i].id] = sumrow(bit, query[i].b)-sumrow(bit,query[i].a-1)+sumcol(bit,query[i].d)-sumcol(bit,query[i].c-1)-(sumpt(bit,query[i].b,query[i].d)-sumpt(bit,query[i].b,query[i].c-1)-sumpt(bit,query[i].a-1,query[i].d)+sumpt(bit,query[i].a-1,query[i].c-1));
			}
		}
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	public static void update(int[][]bit, int r, int c, int val) {
		for(int i = r; i<bit.length; i+=i&(-i)) {
			for(int j = c; j<bit[i].length; j+=j&(-j)) {
				bit[i][j] += val;
			}
		}
	}
	public static int sumrow(int[][]bit, int pos) {
		int sum = 0;
		for(int i = pos; i>0; i-=i&(-i)) {
			for(int j = bit[i].length-1; j>0; j-=j&(-j)) {
				sum += bit[i][j];
			}
		}
		return sum;
	}
	public static int sumcol(int[][]bit, int pos) {
		int sum = 0;
		for(int i = bit.length-1; i>0; i-=i&(-i)) {
			for(int j = pos; j>0; j-=j&(-j)) {
				sum += bit[i][j];
			}
		}
		return sum;
	}
	public static int sumpt(int[][]bit, int r, int c) {
		int sum = 0;
		for(int i = r; i>0; i-=i&(-i)) {
			for(int j = c; j>0; j-=j&(-j)) {
				sum += bit[i][j];
			}
		}
		return sum;
	}
	static class sortByStart implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return Integer.compare(add[a],add[b]);
		}
	}
	static class sortByEnd implements Comparator<Integer>{
		public int compare(Integer a, Integer b) {
			return Integer.compare(rem[a], rem[b]);
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
