package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class TC {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]bit;
	static class Interval implements Comparable<Interval> {
		int id, l, r;
		public Interval(int id, int l, int r) {
			this.id = id;
			this.l = l;
			this.r = r;
		}
		public int compareTo(Interval other) {
			if(this.l<other.l) {
				return -1;
			} else if(this.l>other.l) {
				return 1;
			} else {
				return Integer.compare(this.r, other.r);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt();
		bit = new int[100001];
		ArrayList<Interval>list = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			list.add(new Interval(i, readInt(), readInt()));
		}
		Collections.sort(list);
		int[]ans = new int[N];
		for(int i = 0; i<list.size(); i++) {
			if(i>0 && list.get(i).l==list.get(i-1).l && list.get(i).r==list.get(i-1).r) {
				ans[list.get(i).id] = ans[list.get(i-1).id]; 
			} else {
				ans[list.get(i).id] = query(list.get(i).r);
			}
			update(list.get(i).r);
		}
		for(int i = 0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	public static void update(int x) {
		for(int i = x; i<bit.length; i+=i&(-i)) {
			bit[i]++;
		}
	}
	public static int query(int x) {
		int sum = 0;
		for(int i = x; i>0; i-=i&(-i)) {
			sum += bit[i];
		}
		return sum;
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
