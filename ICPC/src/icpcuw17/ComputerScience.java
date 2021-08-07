package icpcuw17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class ComputerScience {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[]arr;
	static int N, K;
	public static void main(String[] args) throws IOException {
		N = readInt(); K = readInt();
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		Arrays.sort(arr);
		Integer[]sort = new Integer[N-K+1];
		for(int r = K-1; r<arr.length; r++) {
			sort[r-K+1] = r;
		}
		Arrays.sort(sort, new sortByInterval());
		TreeSet<Integer>set = new TreeSet<>();
		for(int i = 0; i<N; i++) set.add(i);
		int max = 0;
		for(int i = 0; i<sort.length && !set.isEmpty(); i++) {
			int x = 0;
			try {
				x = set.floor(sort[i]);
			} catch(NullPointerException e) {
				continue;
			}
			while(x>=sort[i]-K+1) {
				set.remove(x);
				try {
					x = set.floor(sort[i]);
				} catch(NullPointerException e) {
					break;
				}
			}
			max = arr[sort[i]]-arr[sort[i]-K+1];
		}
		System.out.println(max);
	}
	static class sortByInterval implements Comparator<Integer>{
		public int compare(Integer x, Integer y) {
			return Integer.compare(arr[x]-arr[x-K+1], arr[y]-arr[y-K+1]);
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
