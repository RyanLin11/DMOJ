package icpc2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Paint {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class Pair implements Comparable<Pair>{
		long l, r;
		public Pair(long l, long r) {
			this.l = l;
			this.r = r;
		}
		public int compareTo(Pair other) {
			if(this.r<other.r) return -1;
			else if(this.r>other.r) return 1;
			else return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		long n = readLong();
		int k = readInt();
		Pair[]arr = new Pair[k];
		for(int i = 0; i<k; i++) {
			arr[i] = new Pair(readLong(), readLong());
		}
		Arrays.sort(arr);
		//Arrays implementation
		long[]right = new long[k];
		long[]space = new long[k];//stores min space with i capacity
		space[0] = arr[0].l-1;
		right[0] = arr[0].r;
		int len = 0;
		for(int i = 1; i<k; i++) {
			int u = Arrays.binarySearch(right, 0, len+1,arr[i].l-1);
			if(u<0) u=-u-2;
			//System.out.println(u);
			if(arr[i].r==right[len]) {
				if(u<0) space[len] = Math.min(space[len], arr[i].l-1);
				else space[len] = Math.min(space[len], space[u]+arr[i].l-1-arr[u].r);
			} else {
				 len++; right[len] = arr[i].r;
				if(u<0) space[len] = Math.min(arr[i].l-1, right[len]-right[len-1]+space[len-1]);
				else space[len] = Math.min(space[u]+arr[i].l-1-arr[u].r, right[len]-right[len-1]+space[len-1]);
			}
		}
		//System.out.println(len);
		//System.out.println(Arrays.toString(right));
		//System.out.println(Arrays.toString(space));
		System.out.println(n-right[len]+space[len]);
		
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
