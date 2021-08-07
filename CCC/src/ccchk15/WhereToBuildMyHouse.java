package ccchk15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class WhereToBuildMyHouse {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		int l, r;
		public Pair(int l, int r) {
			this.l = l;
			this.r = r;
		}
		public int compareTo(Pair other) {
			if(this.l<other.l)return -1;
			else if(this.l>other.l)return 1;
			else return 0;
		}
		
	}
	public static void main(String[] args) throws IOException {
		int len = readInt();
		int n = readInt();
		Pair[]arr = new Pair[n];
		for(int i = 0; i<n; i++) {
			int s = readInt(), t = readInt();
			arr[i] = new Pair(s, t);
		}
		Arrays.sort(arr);
		ArrayList<Pair>list = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			int u = Collections.binarySearch(list, arr[i]);
			if(u<0) u = -u-2;
			if(!list.isEmpty() && list.get(u).l<=arr[i].l && arr[i].l<=list.get(u).r) {
				list.get(u).r = Math.max(list.get(u).r, arr[i].r);
			} else {
				list.add(arr[i]);
			}
		}
		int max = 0;
		for(int i = 1; i<list.size(); i++) {
			max = Math.max(max, list.get(i).l-list.get(i-1).r);
		}
		max = Math.max(max, list.get(0).l-0);
		max = Math.max(max, len-list.get(list.size()-1).r);
		System.out.println(max);
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
